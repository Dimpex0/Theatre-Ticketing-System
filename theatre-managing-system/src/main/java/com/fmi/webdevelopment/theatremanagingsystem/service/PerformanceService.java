package com.fmi.webdevelopment.theatremanagingsystem.service;

import com.fmi.webdevelopment.theatremanagingsystem.config.AppLogger;
import com.fmi.webdevelopment.theatremanagingsystem.domain.Performance;
import com.fmi.webdevelopment.theatremanagingsystem.dto.PerformanceResponse;
import com.fmi.webdevelopment.theatremanagingsystem.exception.ValidationException;
import com.fmi.webdevelopment.theatremanagingsystem.repository.PerformanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerformanceService {

    private final PerformanceRepository performanceRepository;
    private final ShowService showService;
    private final AppLogger logger;

    public PerformanceService(PerformanceRepository performanceRepository,
                              ShowService showService,
                              AppLogger logger) {
        this.performanceRepository = performanceRepository;
        this.showService = showService;
        this.logger = logger;
    }

    /**
     * Persists a new Performance, first verifying the associated Show exists via {@link ShowService}.
     *
     * @param performance the Performance to save; showId must reference an existing Show
     * @return the saved Performance as a {@link com.fmi.webdevelopment.theatremanagingsystem.dto.PerformanceResponse}
     * @throws com.fmi.webdevelopment.theatremanagingsystem.exception.NotFoundException if the referenced Show does not exist
     * @since Week 06, Task 1
     */
    public PerformanceResponse addPerformance(Performance performance) {
        if (performance == null) throw new ValidationException("Performance must not be null");
        // Validate the show exists via ShowService — not ShowRepository
        showService.getShowById(performance.getShowId());
        logger.debug("Adding performance for show: " + performance.getShowId());
        Performance saved = performanceRepository.save(performance);
        logger.info("Performance added: id=" + saved.getId());
        return PerformanceResponse.from(saved);
    }

    /**
     * Returns all Performances for a given Show.
     * Validates the Show exists via {@link ShowService#getShowById(Long)} before querying.
     *
     * @param showId must not be {@code null}
     * @throws com.fmi.webdevelopment.theatremanagingsystem.exception.NotFoundException if no Show exists for {@code showId}
     * @since Week 06, Task 1
     */
    public List<PerformanceResponse> findPerformancesByShow(Long showId) {
        if (showId == null) throw new ValidationException("showId must not be null");
        // Validate show exists via service (throws 404 if not found)
        showService.getShowById(showId);
        logger.debug("Fetching performances for show: " + showId);
        return performanceRepository.findByShowId(showId).stream()
                .map(PerformanceResponse::from).toList();
    }

    /**
     * Returns all Performances without filtering.
     * Called by {@code GET /api/performances} when no {@code showId} parameter is supplied.
     *
     * @since Week 06, Task 1
     */
    public List<PerformanceResponse> getAllPerformances() {
        return performanceRepository.findAll().stream()
                .map(PerformanceResponse::from).toList();
    }
}
