package com.example.book_exchange.repository;

import com.example.book_exchange.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query(nativeQuery = true, value = "select * from member where email = :email")
    Optional<Member> getByEmail(String email);
}
