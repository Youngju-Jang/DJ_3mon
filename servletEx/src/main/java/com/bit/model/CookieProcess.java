package com.bit.model;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

public class CookieProcess {
     public HashMap<String, String> requestCookie(HttpServletRequest request, String cookName) {
          HashMap<String, String> map = new HashMap<String, String>();
          
          Cookie[] cookies = request.getCookies();
          if (cookies != null && cookies.length > 0) {
               for (int i = 0; i < cookies.length; i++) {
                    System.out.println("cookName : " + cookName + " : value : "+ cookies[i].getValue());
                    if (cookies[i].getName().trim().equalsIgnoreCase("checker")) { // checker 라는 쿠키가 있으면
                         map.put("checker", cookies[i].getValue()); // map 에 쿠키이름:쿠키값 으로 추가
                    }
               }
          }
          return map;
     }
     
     public void cookieCreate(HttpServletRequest request, HttpServletResponse response, String cookName) {
          String checker = request.getParameter("checker"); // checkbox parameter name : checker : on or null
          String id = request.getParameter("id");
          System.out.println(checker + " : " + id);
          Cookie cookie = new Cookie("checker", id); // cookie name : "checker", value : id
          int time = checker != null && checker.equals("on") ? 30 : 0;
          cookie.setMaxAge(time);
          response.addCookie(cookie);
          System.out.println("cook="+cookie.getValue());
     }
}
