package com.fmi.webdevelopment.theatremanagingsystem.repository;

import com.fmi.webdevelopment.theatremanagingsystem.model.Show;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShowRepository {
    Show save(Show show);
    Optional<Show> findById(Long id);
    List<Show> findAll();
    void deleteById(Long id);
    boolean existsById(Long id);
}
