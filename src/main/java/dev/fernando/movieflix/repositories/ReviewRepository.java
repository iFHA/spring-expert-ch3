package dev.fernando.movieflix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.fernando.movieflix.entities.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>{
}
