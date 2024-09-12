package dev.fernando.movieflix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.fernando.movieflix.entities.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
