package dev.fernando.movieflix.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.fernando.movieflix.dto.MovieCardDTO;
import dev.fernando.movieflix.dto.MovieDetailsDTO;
import dev.fernando.movieflix.repositories.MovieRepository;
import dev.fernando.movieflix.services.exceptions.ResourceNotFoundException;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Transactional(readOnly = true)
    public Page<MovieCardDTO> findAllPaged(Pageable pageable, Long genreId) {
        if (genreId == null) {
            genreId = 0L;
        }
        return movieRepository.findAllByGenreOrderByTitle(pageable, genreId);
    }

    @Transactional(readOnly = true)
    public MovieDetailsDTO findById(Long id) {
        return new MovieDetailsDTO(movieRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Filme de Id = %d não encontrado!".formatted(id))));
    }
}
