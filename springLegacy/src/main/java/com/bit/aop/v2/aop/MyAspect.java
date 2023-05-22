package com.bit.aop.v2.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
     
     @Pointcut("execution(public void com.bit.aop.v2.service.Search*.* (..) )")
     private void search(){}
     
     @Before("search()")//when
     public void dataAttributeSearch(JoinPoint joinPoint){
          System.out.println("[전처리]");
          // what
          Signature signature = joinPoint.getSignature();
          String methodName = signature.getName();
          if (methodName.equals("fileSearch")) {
//               System.out.println("fileSearch Before");
          }
          
          //메서드에 들어가는 매개변수 배열을 읽어옴
          Object[] args = joinPoint.getArgs();
          
          //매개변수 배열의 종류와 값을 출력
          for(Object obj : args) {
               System.out.println("type : "+obj.getClass().getSimpleName());
               System.out.println("value : "+obj);
          }
     }
     
     @Around("search()")//정상처리 됐을경우
     public Object aroundAdvice(ProceedingJoinPoint joinPoint){
          Signature signature = joinPoint.getSignature();
          String methodName = signature.getName();
          if (methodName.equals("xmlParsing")) {
               System.out.println("xmlParsing before");
          }
          Object result = null;
          try {
               result = joinPoint.proceed();  // 본 메소드 실행
          } catch (Throwable e) {
               throw new RuntimeException(e);
          }
          
          System.out.println("after proceed"); // pointCut 모든 메소드 실행
          
          return result;
     }
     
     @AfterThrowing("search()") // throw 발생 후
     public void afterThrowingSearchAdvice(JoinPoint joinPoint) {
          Signature signature = joinPoint.getSignature();
          String methodName = signature.getName();
          if (methodName.equals("domSaxSearch")) {
               System.out.println("after domSaxSearch throwing");
          }
     }
}
