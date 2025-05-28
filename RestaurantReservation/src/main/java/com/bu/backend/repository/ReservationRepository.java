package com.bu.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bu.backend.entity.ReservationEntity;

public interface ReservationRepository extends JpaRepository<ReservationEntity, Long>{

}
