//MemberDTO.java는 DB내용을 전달하는 클래스

package com.bu.backend.dto;
import com.bu.backend.entity.MemberEntity;
//롬복은 코드의 재작성을 줄여줌 
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

public class MemberDTO {
	private Long id; //회원 ID
	private String memberEmail; // 회원 이메일 
	private String memberPassword; // 회원 비밀번호
	private String memberName; // 회원 이름
	
	//MemberEntity 객체를 받아서 MemberDTO 객체로 변환하는 정적 메소드
	public static MemberDTO toMemberDTO(MemberEntity memberEntity) {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId(memberEntity.getId());
		memberDTO.setMemberEmail(memberEntity.getMemberEmail());
		memberDTO.setMemberPassword(memberEntity.getMemberPassword());
		memberDTO.setMemberName(memberEntity.getMemberName());
		return memberDTO;
	}
}
