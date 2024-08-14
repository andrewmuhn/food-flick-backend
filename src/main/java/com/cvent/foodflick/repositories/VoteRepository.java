package com.cvent.foodflick.repositories;

import com.cvent.foodflick.models.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VoteRepository extends JpaRepository<Vote, Long> {
    List<Vote> findVotesByRestaurantId(Long restaurantId);
}
