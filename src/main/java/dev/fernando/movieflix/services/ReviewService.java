package dev.fernando.movieflix.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.fernando.movieflix.dto.ReviewDTO;
import dev.fernando.movieflix.entities.Review;
import dev.fernando.movieflix.entities.User;
import dev.fernando.movieflix.repositories.ReviewRepository;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private AuthService authService;

    @Transactional
    public ReviewDTO store(ReviewDTO dto) {
        User user = authService.authenticated();
        dto.setUserEmail(user.getEmail());
        dto.setUserId(user.getId());
        dto.setUserName(user.getName());
        return new ReviewDTO(reviewRepository.save(new Review(dto)));
    }
}
