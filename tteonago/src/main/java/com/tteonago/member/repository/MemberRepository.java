package com.tteonago.member.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tteonago.member.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {
	Optional<Member> findByUsername(String username);
	
	Optional<Member> findByEmail(String email);
	
	@Modifying
	@Query("update Member m set m.role=:role where m.username=:username")
	public int updateMemberByUsername(@Param("role") String role, @Param("username") String username);
}
