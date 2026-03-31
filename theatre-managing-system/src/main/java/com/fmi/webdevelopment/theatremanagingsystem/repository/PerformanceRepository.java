package com.fmi.webdevelopment.theatremanagingsystem.repository;

import com.fmi.webdevelopment.theatremanagingsystem.model.Performance;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PerformanceRepository {
    Performance save(Performance performance);
    Optional<Performance> findById(Long id);
    List<Performance> findAll();
    List<Performance> findByShowId(Long showId);
    void deleteById(Long id);
}