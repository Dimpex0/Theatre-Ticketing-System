package com.fmi.webdevelopment.theatremanagingsystem.repository.inmemory;

import com.fmi.webdevelopment.theatremanagingsystem.domain.Show;
import com.fmi.webdevelopment.theatremanagingsystem.repository.ShowRepository;
import com.fmi.webdevelopment.theatremanagingsystem.vo.AgeRating;
import com.fmi.webdevelopment.theatremanagingsystem.vo.Genre;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class DevInMemoryShowRepository implements ShowRepository {
    private final Map<Long, Show> store = new HashMap<>();
    private final AtomicLong seq = new AtomicLong(1);

    @PostConstruct
    public void seed() {
        save(new Show(nextId(), "Hamlet", "Shakespeare's tragedy", Genre.DRAMA, 120, AgeRating.PG_16));
        save(new Show(nextId(), "Chicago", "Broadway musical", Genre.MUSICAL, 135, AgeRating.PG_12));
        save(new Show(nextId(), "A Midsummer Night's Dream", "Comedy classic", Genre.COMEDY, 95, AgeRating.ALL));
        save(new Show(nextId(), "The Phantom of the Opera", "Epic musical", Genre.MUSICAL, 150, AgeRating.PG_12));
        save(new Show(nextId(), "Swan Lake", "Tchaikovsky's ballet", Genre.BALLET, 140, AgeRating.ALL));
    }

    @Override public Show save(Show s) { store.put(s.getId(), s); return s; }
    @Override public Optional<Show> findById(Long id) { return Optional.ofNullable(store.get(id)); }
    @Override public List<Show> findAll() { return List.copyOf(store.values()); }
    @Override public void deleteById(Long id) { store.remove(id); }
    @Override public boolean existsById(Long id) { return store.containsKey(id); }
    public long nextId() { return seq.getAndIncrement(); }
}
