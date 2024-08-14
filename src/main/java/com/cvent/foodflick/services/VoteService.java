package com.cvent.foodflick.services;

import com.cvent.foodflick.exceptions.ResourceNotFoundException;
import com.cvent.foodflick.mapper.VoteMapper;
import com.cvent.foodflick.models.Restaurant;
import com.cvent.foodflick.models.Vote;
import com.cvent.foodflick.models.dto.CreateVoteDTO;
import com.cvent.foodflick.models.dto.VoteDTO;
import com.cvent.foodflick.repositories.RestaurantRepository;
import com.cvent.foodflick.repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteService {
    private VoteRepository voteRepository;
    private VoteMapper voteMapper;
    private RestaurantRepository restaurantRepository;

    @Autowired
    public VoteService(VoteRepository voteRepository, VoteMapper voteMapper,
            RestaurantRepository restaurantRepository) {
        this.voteRepository = voteRepository;
        this.voteMapper = voteMapper;
        this.restaurantRepository = restaurantRepository;
    }

    public VoteDTO createVote(CreateVoteDTO dto, Long restaurantId){
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(()->new ResourceNotFoundException(String.format("Restaurant with id: %d not found",
                        restaurantId)));
        System.out.println("Restaurant: " + restaurant);
        Vote vote = voteMapper.fromCreateVoteDTO(dto);
        vote.setRestaurant(restaurant);
        Vote createdVote = voteRepository.save(vote);
        return voteMapper.toVoteDTO(createdVote);
    }

    public List<VoteDTO> getAllVotesByRestaurant(Long restaurantId){
        List<Vote> votes = this.voteRepository.findVotesByRestaurantId(restaurantId);
        return votes.stream().map(voteMapper::toVoteDTO).toList();
    }
}
