package com.example.book_exchange.service;

import com.example.book_exchange.model.Member;
import com.example.book_exchange.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Member getMemberById(Long memberId) {
        return memberRepository.findById(memberId).get();
    }

    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }

    public Member updateMember(Member member, Long memberId) {
        Member updateUser = memberRepository.findById(memberId).get();
        updateUser.setName(member.getName());
        updateUser.setEmail(member.getEmail());
        updateUser.setPhno(member.getPhno());
        updateUser.setPassword(member.getPassword());
        updateUser.setLocation(member.getLocation());
        return memberRepository.save(updateUser);
    }

    public void deleteMember(Long memberId) {
        Member deletemember = memberRepository.findById(memberId).get();
        memberRepository.delete(deletemember);
    }

    public String loginMember(String memberEmail, String memberPassword){
        Optional<Member> member = memberRepository.getByEmail(memberEmail);
        if(member.isPresent()){
            Member m = member.get();
            if(Objects.equals(m.getPassword(), memberPassword)){
                return "proceed";
            } else {
                return "wrong password";
            }
        } else {
            return "No account with this email exists";
        }
    }
}
