package dev.fernando.movieflix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.fernando.movieflix.dto.MovieCardDTO;
import dev.fernando.movieflix.dto.MovieDetailsDTO;
import dev.fernando.movieflix.services.MovieService;

@RestController
@RequestMapping("movies")
@PreAuthorize("hasAnyRole('ROLE_VISITOR', 'ROLE_MEMBER')")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<Page<MovieCardDTO>> findAllByGenreSortedByTitle(@RequestParam(required = false) Long genreId, Pageable pageable) {
        return ResponseEntity.ok(movieService.findAllPaged(pageable, genreId));
    }
    
    @GetMapping("{genreId}")
    public ResponseEntity<MovieDetailsDTO> findById(@PathVariable Long genreId) {
        return ResponseEntity.ok(movieService.findById(genreId));
    }
}
