package com.cvent.foodflick.controllers;

import com.cvent.foodflick.models.dto.*;
import com.cvent.foodflick.services.DinnerPartyService;
import com.cvent.foodflick.services.RestaurantService;
import com.cvent.foodflick.services.VoteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dinner-party")
public class DinnerPartyController {
    private final DinnerPartyService dinnerPartyService;
    private final RestaurantService restaurantService;
    private final VoteService voteService;

    @Autowired
    public DinnerPartyController(DinnerPartyService dinnerPartyService, RestaurantService restaurantService,
            VoteService voteService) {
        this.dinnerPartyService = dinnerPartyService;
        this.restaurantService = restaurantService;
        this.voteService = voteService;
    }

    @GetMapping
    public ResponseEntity<List<DinnerPartyDTO>> getDinnerParties(){
        var dinnerParties = dinnerPartyService.getAllDinnerParties();
        return new ResponseEntity<>(dinnerParties, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DinnerPartyDTO> getDinnerPartyById(@PathVariable Long id){
        return new ResponseEntity<>(dinnerPartyService.getDinnerPartyById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DinnerPartyDTO> createDinnerParty(@Valid @RequestBody CreateDinnerPartyDTO dto){
        var dinnerParty = dinnerPartyService.createDinnerParty(dto);

        return new ResponseEntity<>(dinnerParty, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DinnerPartyDTO> updateDinnerParty(@Valid @RequestBody UpdateDinnerPartyDTO dto,
                                                            @PathVariable Long id){
        var dinnerParty = dinnerPartyService.updateDinnerParty(dto, id);

        return new ResponseEntity<>(dinnerParty, HttpStatus.OK);
    }

    @PutMapping("/{id}/lock")
    public ResponseEntity<DinnerPartyDTO> lockDinnerPartyVotes(@Valid @RequestBody LockDinnerPartyVotesDTO dto,
                                                               @PathVariable Long id){
        var dinnerParty = dinnerPartyService.lockDinnerPartyVotes(dto, id);

        return new ResponseEntity<>(dinnerParty, HttpStatus.OK);
    }

    @PostMapping("/{dinnerPartyId}/restaurants")
    public ResponseEntity<DinnerPartyDTO> addRestaurantToDinnerParty(@PathVariable Long dinnerPartyId,
                                                                     @Valid @RequestBody CreateRestaurantDTO createRestaurantDTO) {
        restaurantService.createRestaurantForDinnerParty(dinnerPartyId, createRestaurantDTO);
//        var updatedDinnerPartyDTO = dinnerPartyService.getDinnerPartyById(dinnerPartyId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/restaurant/{restaurantId}/vote")
    public ResponseEntity<List<VoteDTO>> getVotesByRestaurant(@PathVariable Long restaurantId) {
        var votes = voteService.getAllVotesByRestaurant(restaurantId);
        return new ResponseEntity<>(votes, HttpStatus.OK);
    }

    @PostMapping("/restaurant/{restaurantId}/vote")
    public ResponseEntity<VoteDTO> createVote(@PathVariable Long restaurantId, @Valid @RequestBody CreateVoteDTO dto){
        var vote = voteService.createVote(dto, restaurantId);
        return new ResponseEntity<>(vote, HttpStatus.CREATED);
    }
}
