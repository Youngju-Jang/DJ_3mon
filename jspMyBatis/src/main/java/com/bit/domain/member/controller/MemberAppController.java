package com.bit.domain.member.controller;

import com.bit.domain.member.service.MemberService;
import com.bit.domain.member.service.impl.MemberServiceImp;
import com.bit.domain.member.vo.Member;
import com.bit.global.ForWardController;
import com.bit.global.ProcessController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberAppController implements ProcessController {
     private String path;
     private boolean redirect;
     
     public MemberAppController(String path, boolean redirect) {
          this.path = path;
          this.redirect = redirect;
     }
     
     @Override
     public ForWardController execute(HttpServletRequest request, HttpServletResponse response) {
          String state = request.getParameter("state");
          String name = request.getParameter("name");
          String hobby = request.getParameter("hobby");
          int no = (request.getParameter("no") != null)? Integer.parseInt(request.getParameter("no")) : 0;
          Member member = new Member(no, name, hobby);
          if(state.equalsIgnoreCase("add")){
               // insert, update >> rollback 시 둘 다
               MemberServiceImp.instance.insertMember(member);
          }
          if (state.equalsIgnoreCase("mod")) {
               if(no != 0){
                    MemberServiceImp.instance.updateMember(member);
               }
          }
          if (state.equalsIgnoreCase("del")) {
               if(no!=0){
                    MemberServiceImp.instance.deleteMember(no);
               }
          }
          request.setAttribute("memberList", MemberServiceImp.instance.selectAllMember());
          System.out.println("MemberAppController.execute");
          return new ForWardController(path, redirect);
     }
}
