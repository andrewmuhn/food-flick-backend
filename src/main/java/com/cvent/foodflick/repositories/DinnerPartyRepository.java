package com.cvent.foodflick.repositories;

import com.cvent.foodflick.models.DinnerParty;
import com.cvent.foodflick.models.dto.GetDinnerPartyDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DinnerPartyRepository extends JpaRepository<DinnerParty, Long> {
    List<DinnerParty> findDinnerPartiesByCreatedBy(String userId);
}
