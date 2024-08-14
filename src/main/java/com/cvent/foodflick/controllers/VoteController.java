package com.cvent.foodflick.controllers;

import com.cvent.foodflick.models.dto.CreateVoteDTO;
import com.cvent.foodflick.models.dto.VoteDTO;
import com.cvent.foodflick.services.DinnerPartyService;
import com.cvent.foodflick.services.VoteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/dinner-party/vote")
public class VoteController {
    private VoteService voteService;

    @Autowired
    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @GetMapping
    public ResponseEntity<List<VoteDTO>> getVotesByRestaurant(Long restaurantId) {
        var votes = voteService.getAllVotesByRestaurant(restaurantId);
        return new ResponseEntity<>(votes, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VoteDTO> createVote(@Valid @RequestBody CreateVoteDTO dto){
        var vote = voteService.createVote(dto);
        return new ResponseEntity<>(vote, HttpStatus.CREATED);
    }
}
