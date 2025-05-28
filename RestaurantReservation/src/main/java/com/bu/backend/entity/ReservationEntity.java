package com.bu.backend.entity;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.bu.backend.dto.ReservationDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "reservation")
public class ReservationEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long reservation_id;
	
	@Column
	private Long user_id;
	
	@Column
	private Long restaurant_id;
	
	@Column
	private String reservation_people;
	
	@Column
	private String reservation_time;
	
	
	public static ReservationEntity toreservationEntity(ReservationDTO reservationDTO) {
		ReservationEntity reservationEntity= new ReservationEntity();
		//reservationEntity.setReservation_id(reservationDTO.getReservation_id());
		reservationEntity.setReservation_people(reservationDTO.getReservation_people());
		reservationEntity.setReservation_time(reservationDTO.getReservation_time());
		reservationEntity.setUser_id(reservationDTO.getUser_id());
		reservationEntity.setRestaurant_id(reservationDTO.getRestaurant_id());
		return reservationEntity;
	}
}
