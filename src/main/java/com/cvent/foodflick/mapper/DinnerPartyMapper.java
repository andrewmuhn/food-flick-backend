package com.cvent.foodflick.mapper;

import com.cvent.foodflick.models.DinnerParty;
import com.cvent.foodflick.models.dto.CreateDinnerPartyDTO;
import com.cvent.foodflick.models.dto.DinnerPartyDTO;
import com.cvent.foodflick.models.dto.LockDinnerPartyVotesDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {RestaurantMapper.class})
public interface DinnerPartyMapper {
    @Mapping(source = "restaurants", target = "restaurants")
    DinnerPartyDTO toDinnerPartyDTO(DinnerParty dinnerParty);
    DinnerParty toDinnerParty(DinnerPartyDTO dinnerPartyDTO);
    DinnerParty fromCreateDinnerPartyDTO(CreateDinnerPartyDTO createDinnerPartyDTO);
}
