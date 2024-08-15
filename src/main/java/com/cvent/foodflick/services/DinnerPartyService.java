package com.cvent.foodflick.services;

import com.cvent.foodflick.exceptions.ResourceNotFoundException;
import com.cvent.foodflick.mapper.DinnerPartyMapper;
import com.cvent.foodflick.models.DinnerParty;
import com.cvent.foodflick.models.dto.CreateDinnerPartyDTO;
import com.cvent.foodflick.models.dto.DinnerPartyDTO;
import com.cvent.foodflick.models.dto.LockDinnerPartyVotesDTO;
import com.cvent.foodflick.models.dto.UpdateDinnerPartyDTO;
import com.cvent.foodflick.repositories.DinnerPartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DinnerPartyService {
    private DinnerPartyRepository dinnerPartyRepository;

    @Autowired
    private DinnerPartyMapper dinnerPartyMapper;

    @Autowired
    public DinnerPartyService(DinnerPartyRepository dinnerPartyRepository){
        this.dinnerPartyRepository = dinnerPartyRepository;
    }

    public List<DinnerPartyDTO> getAllDinnerParties(){
        List<DinnerParty> dinnerParties = this.dinnerPartyRepository.findAll();
        return dinnerParties.stream().map(dinnerPartyMapper::toDinnerPartyDTO).toList();
    }

    public DinnerPartyDTO getDinnerPartyById(Long id){
        var dinnerParty = this.dinnerPartyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dinner Party not found with id: " + id));
        return dinnerPartyMapper.toDinnerPartyDTO(dinnerParty);
    }

    public DinnerPartyDTO createDinnerParty(CreateDinnerPartyDTO dto){
        DinnerParty dinnerParty = dinnerPartyMapper.fromCreateDinnerPartyDTO(dto);
        DinnerParty createdDinnerParty = dinnerPartyRepository.save(dinnerParty);
        return dinnerPartyMapper.toDinnerPartyDTO(createdDinnerParty);
    }

    public DinnerPartyDTO updateDinnerParty(UpdateDinnerPartyDTO dto, Long id){
        DinnerParty dinnerParty = dinnerPartyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dinner Party not found with id:" + id));
        dinnerParty.setParty_name(dto.getParty_name());
        dinnerParty.setLocation(dto.getLocation());
        dinnerParty.setParty_date(dto.getParty_date());
        dinnerParty.setParty_time(dto.getParty_time());
        dinnerParty.setVotingStrategy(dto.getVotingStrategy());
        DinnerParty updatedDinnerParty = dinnerPartyRepository.save(dinnerParty);

        return dinnerPartyMapper.toDinnerPartyDTO(updatedDinnerParty);
    }

    public DinnerPartyDTO lockDinnerPartyVotes(LockDinnerPartyVotesDTO dto, Long id){
        DinnerParty dinnerParty = dinnerPartyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dinner Party not found with id:" + id));
        dinnerParty.setFinalized(dto.isFinalized());
        DinnerParty updatedDinnerParty = dinnerPartyRepository.save(dinnerParty);

        return dinnerPartyMapper.toDinnerPartyDTO(updatedDinnerParty);
    }
}
