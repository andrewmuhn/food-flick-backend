package com.cvent.foodflick.mapper;

import com.cvent.foodflick.models.Vote;
import com.cvent.foodflick.models.dto.CreateVoteDTO;
import com.cvent.foodflick.models.dto.VoteDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VoteMapper {
    VoteDTO toVoteDTO(Vote vote);
    Vote toVote(VoteDTO vote);
    Vote fromCreateVoteDTO(CreateVoteDTO createVoteDTO);
}
