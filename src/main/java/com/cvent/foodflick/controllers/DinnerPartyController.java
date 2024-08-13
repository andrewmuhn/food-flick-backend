package com.cvent.foodflick.controllers;

import com.cvent.foodflick.models.dto.CreateDinnerPartyDTO;
import com.cvent.foodflick.models.dto.DinnerPartyDTO;
import com.cvent.foodflick.models.dto.UpdateDinnerPartyDTO;
import com.cvent.foodflick.services.DinnerPartyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/DinnerParty")
public class DinnerPartyController {
    private DinnerPartyService dinnerPartyService;
    private final RestaurantService restaurantService;

    @Autowired
    public DinnerPartyController(DinnerPartyService dinnerPartyService, RestaurantService restaurantService) {
        this.dinnerPartyService = dinnerPartyService;
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public ResponseEntity<List<DinnerPartyDTO>> getDinnerParties(){
        var dinnerParties = dinnerPartyService.getAllDinnerParties();
        return new ResponseEntity<>(dinnerParties, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DinnerPartyDTO> getRecipeById(@PathVariable Long id){
        return new ResponseEntity<>(dinnerPartyService.getDinnerPartyById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DinnerPartyDTO> createDinnerParty(@Valid @RequestBody CreateDinnerPartyDTO dto){
        var dinnerParty = dinnerPartyService.createDinnerPArty(dto);

        return new ResponseEntity<>(dinnerParty, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DinnerPartyDTO> updateDinnerParty(@Valid @RequestBody UpdateDinnerPartyDTO dto,
                                                            @PathVariable Long id){
        var dinnerParty = dinnerPartyService.updateDinnerParty(dto, id);

        return new ResponseEntity<>(dinnerParty, HttpStatus.OK);
    }

}
