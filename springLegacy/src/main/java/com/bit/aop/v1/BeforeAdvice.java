package com.bit.aop.v1;

import org.springframework.stereotype.Component;

@Component
public class BeforeAdvice implements org.springframework.aop.BeforeAdvice {
     public void beforeMethod(){
          System.out.println("BeforeAdvice.beforeMethod");
     }
}
