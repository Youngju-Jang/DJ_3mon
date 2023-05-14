package com.bit.data.member;

import com.bit.domain.member.vo.Member;

import java.util.List;

public interface MemberMapper {
     void insertMember(Member member);
     List<Member> selectAllMember();
     void updateMember(Member member);
     void deleteMember(int no);
}
