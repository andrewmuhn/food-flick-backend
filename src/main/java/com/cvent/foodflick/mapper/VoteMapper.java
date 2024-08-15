package com.cvent.foodflick.mapper;

import com.cvent.foodflick.models.Vote;
import com.cvent.foodflick.models.dto.CreateVoteDTO;
import com.cvent.foodflick.models.dto.VoteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VoteMapper {
    @Mapping(source="restaurant.restaurant_id", target = "restaurant_id")
    VoteDTO toVoteDTO(Vote vote);
    Vote toVote(VoteDTO dto);
    Vote fromCreateVoteDTO(CreateVoteDTO dto);
}
