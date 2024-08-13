package com.cvent.foodflick.repositories;

import com.cvent.foodflick.models.DinnerParty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DinnerPartyRepository extends JpaRepository<DinnerParty, Long> {
}
