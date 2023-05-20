package com.bit.web.v5;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Scope(value = "singleton")
//@Component
//@ComponentScan(value="com.bit.web.v5")
@AllArgsConstructor
public class StateServer {
     
//     @Value("127.0.0.1:8080:dbmsMysql")
     private String serverUrl;
     private int port;
     private String account;
     private String password;
     
}
