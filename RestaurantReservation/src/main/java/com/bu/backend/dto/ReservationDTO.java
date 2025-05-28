package com.bu.backend.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReservationDTO {
	private Long reservation_id;
	private Long user_id;
	private Long restaurant_id;
	private String reservation_people;
	private String reservation_time;
}
