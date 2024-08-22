package com.cvent.foodflick;

import com.cvent.foodflick.models.VotingStrategy;
import com.cvent.foodflick.models.YelpMetaData;
import com.cvent.foodflick.models.dto.CreateRestaurantDTO;
import com.cvent.foodflick.models.dto.DinnerPartyDTO;
import com.cvent.foodflick.services.DinnerPartyService;
import com.cvent.foodflick.services.RestaurantService;
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
public class RestaurantTests
{
    @Autowired
    private RestaurantService restaurantService;

    @MockBean
    private DinnerPartyService mockDinnerPartyService;

    @MockBean
    private AuditorAware<String> auditorAware;

    @BeforeEach
    public void setUp() {
        Mockito.when(auditorAware.getCurrentAuditor()).thenReturn(Optional.of("testUserId"));
    }

    @Test
    public void postNewRestaurant() {
        DinnerPartyDTO mockDinnerParty = new DinnerPartyDTO();
        mockDinnerParty.setDinner_party_id(1L);
        mockDinnerParty.setParty_name("Mock Party");
        mockDinnerParty.setVoting_strategy(VotingStrategy.DEFAULT);
        mockDinnerParty.setParty_date(LocalDateTime.of(2024, 8, 25, 18, 0));

        Mockito.when(mockDinnerPartyService.getDinnerPartyById(1L)).thenReturn(mockDinnerParty);

        CreateRestaurantDTO restaurant = new CreateRestaurantDTO();
        YelpMetaData yelpMetaData = new YelpMetaData();
        yelpMetaData.setYelp_id("rJY7EbVlXPXWgwojyEJq8w");
        restaurant.setYelpMetaData(yelpMetaData);

        var createdRestaurant = restaurantService.createRestaurantForDinnerParty(1L, restaurant);

        Assertions.assertNotNull(createdRestaurant);
        Assertions.assertEquals(createdRestaurant.getYelpMetaData().getYelp_id(), restaurant.getYelpMetaData().getYelp_id());
    }
}
