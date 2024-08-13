package com.cvent.foodflick.services;

import com.cvent.foodflick.mapper.VoteMapper;
import com.cvent.foodflick.repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class VoteService {
    private VoteRepository voteRepository;

    @Autowired
    private VoteMapper voteMapper;

    @Autowired
    public VoteService(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }
}
