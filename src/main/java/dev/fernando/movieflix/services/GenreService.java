package dev.fernando.movieflix.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import dev.fernando.movieflix.dto.GenreDTO;
import dev.fernando.movieflix.repositories.GenreRepository;

@Service
public class GenreService {
    @Autowired
    private GenreRepository genreRepository;

    @Transactional(readOnly = true)
    public List<GenreDTO> findAll() {
        return genreRepository.findAll().stream().map(GenreDTO::new).toList();
    }
}
