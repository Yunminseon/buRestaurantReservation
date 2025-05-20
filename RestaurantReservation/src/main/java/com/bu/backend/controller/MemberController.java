//MemberController.java는 회원가입, 로그인, 회원 목록 조회와 관련된 기능을 처리하는 클래스
package com.bu.backend.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.bu.backend.dto.MemberDTO;
import com.bu.backend.exception.LoginFailedException;
import com.bu.backend.service.MemberService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class MemberController {
	private final MemberService memberService;
	
	//회원가입 페이지 출력 요청 즉 회원가입 양식페이지를 보여줌
	@GetMapping("/member/save")
	public String  saveForm() {
		return "save";
	}
	
	//사용자가 입력한 데이터를 memberDTO로 받아서 memberService.save()호출하고 회원가입 정보를 저장 후 login.html로 이동
	@PostMapping("/member/save")
	public String save(@ModelAttribute MemberDTO memberDTO) {
		System.out.println("MemberController.save");
		System.out.println("memberDTO = " + memberDTO);
		memberService.save(memberDTO);
		return "login";
	}
	
	//로그인 페이지 출력 
	@GetMapping("/member/login")
	public String loginForm() {
		return "login";
	}
	
	//로그인처리 memberDTO로 입력된 정보 받는다 성공시 -> main.html이동 실패시 -> LofinFailedException 
	@PostMapping("/member/login")
	public String  login(@ModelAttribute MemberDTO memberDTO, HttpSession session) {
		MemberDTO loginResult = memberService.login(memberDTO);
		if(loginResult != null) {
			//로그인 성공
			session.setAttribute("loginEmail", loginResult.getMemberEmail());
			return "main";
		}else {
			//로그인 실패
			throw new LoginFailedException("아이디 또는 비밀번호가 일치하지 않습니다.");
		}
	}
	
	//회원 전체 조회
	@GetMapping("/member/")
	public String findAll(Model model) {
		List<MemberDTO> memberDTOlist = memberService.findAll();
		model.addAttribute("memberList", memberDTOlist);
		return "memberList";
	}

}
  