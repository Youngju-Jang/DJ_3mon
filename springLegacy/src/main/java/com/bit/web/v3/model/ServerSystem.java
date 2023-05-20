package com.bit.web.v3.model;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Getter @Setter
@ToString
@RequiredArgsConstructor
@Component
public class ServerSystem {
     @Autowired
     private final DbmsSystem dbmsSystem;
     
     public void test(){
          System.out.println(dbmsSystem.getServerName());
     }
}
