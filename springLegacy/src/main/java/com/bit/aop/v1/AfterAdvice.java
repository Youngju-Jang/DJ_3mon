package com.bit.aop.v1;

import org.springframework.stereotype.Component;

@Component
public class AfterAdvice implements org.springframework.aop.AfterAdvice {
     public void afterMethod(){
          System.out.println("AfterAdvice.afterMethod");
     }
}
