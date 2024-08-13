package com.cvent.foodflick.mapper;

import com.cvent.foodflick.models.Vote;
import com.cvent.foodflick.models.dto.CreateVoteDTO;
import com.cvent.foodflick.models.dto.VoteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {VoteMapper.class})
public interface VoteMapper {
    @Mapping(source = "votes", target = "votes")
    VoteDTO toVoteDTO(Vote vote);
    Vote fromCreateVoteDTO(CreateVoteDTO createVoteDTO);
}
