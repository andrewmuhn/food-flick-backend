package com.cvent.foodflick;

import com.cvent.foodflick.models.VotingStrategy;
import com.cvent.foodflick.models.dto.DinnerPartyDTO;
import com.cvent.foodflick.services.DinnerPartyService;
import com.cvent.foodflick.services.RestaurantService;
import com.cvent.foodflick.services.VoteService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;

@SpringBootTest
public class VoteTests {
    @MockBean
    private DinnerPartyService mockDinnerPartyService;

    @MockBean
    private RestaurantService mockRestaurantService;

    @Autowired
    private VoteService voteService;

    @Test
    public void postNewVote(){
        DinnerPartyDTO mockDinnerParty = new DinnerPartyDTO();
        mockDinnerParty.setDinner_party_id(1L);
        mockDinnerParty.setParty_name("Mock Party");
        mockDinnerParty.setVoting_strategy(VotingStrategy.DEFAULT);
        mockDinnerParty.setParty_date(LocalDateTime.of(2024, 8, 25, 18, 0));

        Mockito.when(mockDinnerPartyService.getDinnerPartyById(1L)).thenReturn(mockDinnerParty);
    }
}
