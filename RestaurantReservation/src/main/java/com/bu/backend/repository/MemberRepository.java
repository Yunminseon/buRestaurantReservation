// MemberRepository.java는 Spring Data JPA를 사용하여 회원 정보를 데이터베이스에서 조회하거나 저장하는 역할을 하는 Repository 인터페이스
package com.bu.backend.repository; // Spring Data JPA가 제공하는 기본 CRUD 메서드를 자동으로 사용할 수 있게 해주는 인터페이스

import java.util.Optional; // null 값을 처리하는 wrapper 클래스

import org.springframework.data.jpa.repository.JpaRepository;

import com.bu.backend.entity.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity, Long>{
//이메일로 회원정보 조회 (select * from member_table where member_email=?)
	Optional<MemberEntity> findByMemberEmail(String memberEmail);
}