package com.bit.web.v5.conf;

import com.bit.web.v5.DmlServer;
import com.bit.web.v5.StateServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@ImportResource({"appConfig.xml"})
@Configuration
public class ConfigDemo {
     
     @Bean(name="stateServer")
     public StateServer getStateServer() {
          return new StateServer("127.0.0.1:8080:mys1l", 7777, "scott", "tiger");
     }
     
     @Bean
     public DmlServer getDmlServer(){
          return new DmlServer(new StateServer("127.0.0.1:8080:stop", 88, "user", "tiger"));
     }
     @Bean
     public Map<String, String> getMap(){
          HashMap<String, String> map = new HashMap<>();
          map.put("1", "딸기");
          map.put("2", "수박");
          map.put("3", "바나나");
          map.put("4", "망고");
          return map;
     }
     
     @Bean
     public Properties getProperties(){
          Properties p = new Properties();
          p.put("/web/list/userList", getMap());
          p.put("/web/login/userLogin", getDmlServer());
          return p;
     }
}
