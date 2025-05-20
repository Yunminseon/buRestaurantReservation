package com.bu.backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bu.backend.dto.MemberDTO;
import com.bu.backend.entity.MemberEntity;
import com.bu.backend.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
	
	private final MemberRepository memberRepository;

	public void save(MemberDTO memberDTO) {
		/* 
		 * 1. dto -> entity 변환
		 * 2. repository의 save 메서드 호출
		 */ 
	MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO);
	memberRepository.save(memberEntity);
		// repository의 save 메서드 호출(entity 객체를 넘겨줘야 함)
	}

	public MemberDTO login(MemberDTO memberDTO) {
		/*
		 * 1.회원이 입력한 이메일로 DB에서 조회를함
		 * 2.DB에서 조회한비밀번호와 사용자가 입력한 비밀번호가 일치하는지 판단
		 */
		Optional<MemberEntity> byMemberEmail = memberRepository.findByMemberEmail(memberDTO.getMemberEmail());
		if (byMemberEmail.isPresent()) {
			// DB에 이메일 조회 결과가 있다
			MemberEntity memberEntity = byMemberEmail.get();
			if(memberEntity.getMemberPassword().equals(memberDTO.getMemberPassword())) {
//				비밀번호 일치
//				entity -> dto 변환후 리턴
				
				MemberDTO dto = MemberDTO.toMemberDTO(memberEntity);
				return dto;
			} else {
//			 비밀번호 불일치
				return null;
			}
		} else {
			//조회 결과가 없다
			return null;
		}
	}

	public List<MemberDTO> findAll() {
		List<MemberEntity> memberEntityList = memberRepository.findAll();
		List<MemberDTO> memberDTOList = new ArrayList<>();
		for(MemberEntity memberEntity: memberEntityList) {
			memberDTOList.add(MemberDTO.toMemberDTO(memberEntity));
			
		}
		return memberDTOList;
	}

}
