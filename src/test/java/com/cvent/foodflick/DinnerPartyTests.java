package com.cvent.foodflick;

import com.cvent.foodflick.models.DinnerParty;
import com.cvent.foodflick.models.VotingStrategy;
import com.cvent.foodflick.models.YelpMetaData;
import com.cvent.foodflick.models.dto.CreateDinnerPartyDTO;
import com.cvent.foodflick.models.dto.CreateRestaurantDTO;
import com.cvent.foodflick.services.DinnerPartyService;
import com.cvent.foodflick.services.RestaurantService;
import com.cvent.foodflick.services.VoteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.AuditorAware;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
public class DinnerPartyTests {

    @Autowired
    private DinnerPartyService dinnerPartyService;


    @Autowired
    RestaurantService restaurantService;

    @Autowired
    VoteService voteService;

    @MockBean
    private AuditorAware<String> auditorAware;

    @BeforeEach
    public void setUp() {
        Mockito.when(auditorAware.getCurrentAuditor()).thenReturn(Optional.of("testUserId"));
    }

    @Test
    public void postNewDinnerParty() {
        CreateDinnerPartyDTO dinnerParty = new CreateDinnerPartyDTO();
        dinnerParty.setParty_name("Test Party");
        dinnerParty.setVoting_strategy(VotingStrategy.DEFAULT);
        dinnerParty.setParty_date(LocalDateTime.of(2024, 8, 25, 18, 0));

        var createdDinnerParty = dinnerPartyService.createDinnerParty(dinnerParty);

        Assertions.assertNotNull(createdDinnerParty);
        Assertions.assertEquals(createdDinnerParty.getParty_name(), dinnerParty.getParty_name());
        Assertions.assertEquals(createdDinnerParty.getVoting_strategy(), dinnerParty.getVoting_strategy());
        Assertions.assertEquals(createdDinnerParty.getParty_date(), dinnerParty.getParty_date());
    }
}
