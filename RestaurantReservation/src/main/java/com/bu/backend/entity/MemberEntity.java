//MemberEntity.java는 회원정보를 DB에저장하는 JPA 엔티티 클래스
package com.bu.backend.entity;

import com.bu.backend.dto.MemberDTO;

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
@Table(name = "member_table")
// DB에 저장될 id, 이메일, 비밀번호, 이름
public class MemberEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true) // 중복 방지조건 
	private String memberEmail; 
	
	@Column
	private String memberPassword;
	
	@Column
	private String memberName;
	
	public static MemberEntity toMemberEntity(MemberDTO memberDTO) {
		MemberEntity memberEntity = new MemberEntity();
		memberEntity.setMemberEmail(memberDTO.getMemberEmail());
		memberEntity.setMemberPassword(memberDTO.getMemberPassword());
		memberEntity.setMemberName(memberDTO.getMemberName());
		  return memberEntity;
	}


}
