package com.fmi.webdevelopment.theatremanagingsystem.service;

import com.fmi.webdevelopment.theatremanagingsystem.vo.Genre;
import com.fmi.webdevelopment.theatremanagingsystem.domain.Performance;
import com.fmi.webdevelopment.theatremanagingsystem.domain.Show;
import com.fmi.webdevelopment.theatremanagingsystem.repository.PerformanceRepository;
import com.fmi.webdevelopment.theatremanagingsystem.repository.ShowRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class CatalogueService {
//    private final ShowRepository showRepository;
//    private final PerformanceRepository performanceRepository;
//    private final int defaultPageSize = 10;
//
//    public Show addShow(Show show) {
//        if (show == null) throw new IllegalArgumentException("show must not be null");
//        return showRepository.save(show);
//    }
//
//    public Optional<Show> findShowById(Long id) {
//        if (id == null) throw new IllegalArgumentException("id must not be null");
//        return showRepository.findById(id);
//    }
//
//    public List<Show> searchShows(String titleQuery, Genre genre, int page, int size) {
//        if (page < 0) throw new IllegalArgumentException("page must not be negative");
//        if (size <= 0) throw new IllegalArgumentException("size must be positive");
//
//        List<Show> results = showRepository.findAll().stream()
//                .filter(s -> titleQuery == null || titleQuery.isBlank()
//                        || s.getTitle().toLowerCase().contains(titleQuery.toLowerCase()))
//                .filter(s -> genre == null || genre.equals(s.getGenre()))
//                .sorted(Comparator.comparing(Show::getTitle))
//                .collect(Collectors.toList());
//
//        int fromIndex = page * size;
//        if (fromIndex >= results.size()) return List.of();
//        int toIndex = Math.min(fromIndex + size, results.size());
//        return results.subList(fromIndex, toIndex);
//    }
//
//    public List<Show> searchShows(String titleQuery, Genre genre) {
//        return searchShows(titleQuery, genre, 0, defaultPageSize);
//    }
//
//    public List<Show> getAllShows() {
//        return showRepository.findAll();
//    }
//
//    public Performance addPerformance(Performance performance) {
//        if (performance == null) throw new IllegalArgumentException("performance must not be null");
//        if (!showRepository.existsById(performance.getShowId())) {
//            throw new IllegalArgumentException("Show not found: " + performance.getShowId());
//        }
//        return performanceRepository.save(performance);
//    }
//
//    public List<Performance> findPerformancesByShow(Long showId) {
//        if (showId == null) throw new IllegalArgumentException("showId must not be null");
//        if (!showRepository.existsById(showId)) {
//            throw new IllegalArgumentException("Show not found: " + showId);
//        }
//        return performanceRepository.findByShowId(showId);
//    }
}
