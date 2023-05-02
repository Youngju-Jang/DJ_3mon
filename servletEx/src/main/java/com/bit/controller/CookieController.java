package com.bit.controller;

import com.bit.model.CookieProcess;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieController implements ProcessController {
     
     private String path;
     private boolean redirect;
     private CookieProcess cookieProcess = new CookieProcess();
     
     public CookieController(String path, boolean redirect) {
          this.path = path;
          this.redirect = redirect;
     }
     
//          public ForwardController execute(HttpServletRequest request, HttpServletResponse response) {
//          String cookieName = request.getParameter("cookieName"); // ?cookieName = checker
//          cookieProcess.cookieCreate(request, response, cookieName); // 쿠키 생성
          // 쿠키로 맵만들어서 세션에 저장
//          request.getSession().setAttribute("cookieRequest", cookieProcess.requestCookie(request, cookieName));
//          return new ForwardController(path, redirect);
//     }
     @Override
     public ForwardController execute(HttpServletRequest request, HttpServletResponse response) {
          String cookieName = request.getParameter("cookieName");
          String state = request.getParameter("state");
          System.out.println("state: " + state +", cookieName : " + cookieName);
//     		if(state.equals("req")) {
//     		request.getSession().setAttribute("cookieRequest", cookieProcess.requestCookie(request, cookieName));
//     		}else if(state.equals("create")) {
//     			cookieProcess.cookieCreate(request, response, state);
////				this.path = request.getContextPath() + "/cookie.do?cmd=cookie&cookieName=checker&state=req";
//     		}
         
          cookieProcess.cookieCreate(request, response, cookieName); // 쿠키 생성
          // 쿠키로 맵만들어서 세션에 저장
          request.getSession().setAttribute("cookieRequest", cookieProcess.requestCookie(request, cookieName));
          System.out.println("cookieRequest :" +request.getSession().getAttribute("cookieRequest").toString());
          
          return new ForwardController(path, redirect);
          
//          if (state.equals("create")) {
//               cookieProcess.cookieCreate(request, response, state);
//          }
//          request.getSession().setAttribute("cookieRequest", cookieProcess.requestCookie(request, cookieName));
//          System.out.println("cookieRequest :" +request.getSession().getAttribute("cookieRequest"));
//          return new ForwardController(path, redirect);
     }
}
