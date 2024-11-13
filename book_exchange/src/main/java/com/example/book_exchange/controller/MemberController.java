package com.example.book_exchange.controller;

import com.example.book_exchange.model.Member;
import com.example.book_exchange.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/member")
public class MemberController {

    @Autowired
    MemberService memberService;

    @PostMapping
    public Member createMember(@RequestBody Member member){
        return memberService.saveMember(member);
    }

    @PostMapping("/{memberId}")
    public Member updateMember(@PathVariable Long memberId, @RequestBody Member member){
        return memberService.updateMember(member,memberId);
    }

    @GetMapping("/{memberId}")
    public Member getMemberById(@PathVariable Long memberId){
        return memberService.getMemberById(memberId);
    }

    @GetMapping
    public List<Member> getAllMembers(){
        return memberService.getAllMembers();
    }

    @DeleteMapping("/{memberId}")
    public void deleteMember(@PathVariable Long memberId){
        memberService.deleteMember(memberId);
    }

    @GetMapping("/login/{memberEmail}/{memberPassword}")
    public String loginMember(@PathVariable String memberEmail, @PathVariable String memberPassword){
        return memberService.loginMember(memberEmail, memberPassword);
    }
}
