package com.bit.web.v3.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//@Configuration
@Getter @Setter @ToString
@Component
public class DbmsSystem {
     @Value ("${com.bit.serverName}")
     private String serverName;
     
     @Value ("${com.bit.serverPort}")
     private int serverPort;
     
     @Value ("${com.bit.serverUrl}")
     private String serverUrl;
     
     @Value ("${com.bit.connectionCount}")
     private int connectionCount;
}
