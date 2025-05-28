package com.bu.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bu.backend.dto.ReservationDTO;
import com.bu.backend.service.ReservationService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ReservationController {
	
	private final ReservationService reservationService;
	
	@PostMapping("/api/reservations")
	public String createReservation(@ModelAttribute ReservationDTO reservationDTO, HttpSession session) {
		// 세션에서 사용자 ID 가져오기
		Long userId = (Long) session.getAttribute("loginId");
		if (userId == null) {
			return "redirect:/member/login";
		}
		
		// 사용자 ID 설정
		reservationDTO.setUser_id(userId);
		
		// 예약 저장
		reservationService.save(reservationDTO);
		
		return "redirect:/main";
	}
}