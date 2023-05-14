package com.bit.domain.member.service;

import com.bit.domain.member.vo.Member;

import java.util.List;

public interface MemberService {
     public void insertMember(Member member);
     
     public void deleteMember(int no);
     public List<Member> selectAllMember();
     public void updateMember(Member member);
}
