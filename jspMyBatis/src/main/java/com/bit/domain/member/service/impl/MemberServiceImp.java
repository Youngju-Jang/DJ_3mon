package com.bit.domain.member.service.impl;

import com.bit.domain.member.dao.impl.MemberDaoImp;
import com.bit.domain.member.service.MemberService;
import com.bit.domain.member.vo.Member;

import java.util.List;

public class MemberServiceImp implements MemberService {
     public static final MemberService instance = new MemberServiceImp();
     
     @Override
     public void insertMember(Member member) {
          MemberDaoImp.instance.insertMember(member);
     }
     
     @Override
     public void deleteMember(int no) {
          MemberDaoImp.instance.deleteMember(no);
     }
     
     @Override
     public List<Member> selectAllMember() {
          return MemberDaoImp.instance.selectAllMember();
     }
     
     @Override
     public void updateMember(Member member) {
          MemberDaoImp.instance.updateMember(member);
     }
}
