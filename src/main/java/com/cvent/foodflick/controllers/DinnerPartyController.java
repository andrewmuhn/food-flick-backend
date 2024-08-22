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
    public ResponseEntity<List<GetDinnerPartyDTO>> getDinnerParties(){
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

    @PutMapping("/{id}/location")
    public ResponseEntity<DinnerPartyDTO> updateDinnerPartyLocation(@Valid @RequestBody UpdateDinnerPartyLocationDTO dto,
                                                            @PathVariable Long id){
        dinnerPartyService.updateDinnerPartyLocation(dto, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}/lock")
    public ResponseEntity<DinnerPartyDTO> lockDinnerPartyVotes(@PathVariable Long id){
        var dinnerParty = dinnerPartyService.lockDinnerPartyVotes(id);

        return new ResponseEntity<>(dinnerParty, HttpStatus.OK);
    }

    @PostMapping("/{dinnerPartyId}/restaurant")
    public ResponseEntity<RestaurantDTO> addRestaurantToDinnerParty(@PathVariable Long dinnerPartyId,
                                                                     @Valid @RequestBody CreateRestaurantDTO createRestaurantDTO) {
        var restaurant = restaurantService.createRestaurantForDinnerParty(dinnerPartyId, createRestaurantDTO);
        return new ResponseEntity<>(restaurant, HttpStatus.CREATED);
    }

    @GetMapping("/restaurant/{restaurantId}/vote")
    public ResponseEntity<List<VoteDTO>> getVotesByRestaurant(@PathVariable Long restaurantId) {
        var votes = voteService.getAllVotesByRestaurant(restaurantId);
        return new ResponseEntity<>(votes, HttpStatus.OK);
    }

    @PostMapping("/restaurant/{restaurantId}/vote")
    public ResponseEntity<VoteDTO> addVoteToRestaurant(@PathVariable Long restaurantId, @Valid @RequestBody CreateVoteDTO dto){
        var vote = voteService.createVoteForRestaurant(dto, restaurantId);
        return new ResponseEntity<>(vote, HttpStatus.CREATED);
    }
}
