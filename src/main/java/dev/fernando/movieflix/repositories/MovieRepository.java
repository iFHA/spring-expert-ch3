package dev.fernando.movieflix.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.fernando.movieflix.dto.MovieCardDTO;
import dev.fernando.movieflix.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query(value = "SELECT new dev.fernando.movieflix.dto.MovieCardDTO(obj) FROM Movie obj JOIN genre WHERE :genreId = 0 OR obj.genre.id = :genreId ORDER BY obj.title",
    countQuery = "SELECT count(obj) FROM Movie obj JOIN genre WHERE :genreId = 0 OR obj.genre.id = :genreId")
    public Page<MovieCardDTO> findAllByGenreOrderByTitle(Pageable pageable, Long genreId);
}
