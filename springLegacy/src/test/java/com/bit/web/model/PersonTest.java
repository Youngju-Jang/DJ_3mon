package com.bit.web.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

class PersonTest {
     static final ApplicationContext applicationContext = new GenericXmlApplicationContext("person.xml");
     
     static Person protoTypePerson; // ProtoType
     static Person singletonTypePerson; // SingletonType
     
     static {
          protoTypePerson = applicationContext.getBean("person1", Person.class);
          singletonTypePerson = applicationContext.getBean("person2", Person.class);
     }
     
     @Test
     @DisplayName("프로토 타입은 리턴 값으로 동일 객체를 돌려주지 않는다.")
     void protoTypePersonTest() {
          Person mayBeProtoPerson = applicationContext.getBean("person1", Person.class);
          assertThat(protoTypePerson).isNotSameAs(mayBeProtoPerson);
     }
     
     @Test
     @DisplayName ("싱글턴 타입은 리턴 값으로 동일 객체를 돌려준다.")
     void singletonTypePersonTest() {
          Person mayBeSingletonPerson = applicationContext.getBean("person2", Person.class);
          assertThat(singletonTypePerson).isEqualTo(mayBeSingletonPerson);
     }
     
}