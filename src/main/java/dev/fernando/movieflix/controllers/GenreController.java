package dev.fernando.movieflix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import dev.fernando.movieflix.dto.GenreDTO;
import dev.fernando.movieflix.services.GenreService;

@RestController
@RequestMapping("genres")
public class GenreController {
    
    @Autowired
    private GenreService genreService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_VISITOR', 'ROLE_MEMBER')")
    public ResponseEntity<List<GenreDTO>> findAll() {
        return ResponseEntity.ok(genreService.findAll());
    }
}
