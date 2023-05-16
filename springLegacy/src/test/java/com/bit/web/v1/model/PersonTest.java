package com.bit.web.v1.model;

import com.bit.web.v1.model.Person;
import com.bit.web.v1.model.PersonCollection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;

class PersonTest {
     static final ApplicationContext applicationContext = new GenericXmlApplicationContext("appConfig.xml");
     
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
     
     @Test
     @DisplayName("생성자 매개변수 1개 주입된 빈의 필드값 확인")
     void oneConstructorArgTest(){
          System.out.println("start");
          Person nameArgPerson = applicationContext.getBean("person3", Person.class);
          assertThat(nameArgPerson.getName()).isEqualTo("jyj");
     }
     
     @Test
     @DisplayName("생성자 매개변수 2개 주입된 빈의 필드값 확인")
     void towConstructorArgTest(){
          Person nameAgeArgPerson = applicationContext.getBean("person4", Person.class);
          assertThat(nameAgeArgPerson.getName()).isEqualTo("jyj");
          assertThat(nameAgeArgPerson.getAge()).isEqualTo(20);
     }
     
     @Test
     @DisplayName("List를 필드값으로 가진 PersonCollection 빈 필드객체 사이즈 확인")
     void checkListSizeOfPersonCollection(){
          PersonCollection collectionBean = applicationContext.getBean("pc1", PersonCollection.class);
          assertThat(collectionBean.getList().size()).isEqualTo(5);
     }
     
     @Test
     @DisplayName("싱글톤 콜렉션빈에 properties 추가 후 비교하기")
     void 콜렉션빈_프로퍼티추가후_비교하기(){
          PersonCollection collectionBean = applicationContext.getBean("pc1", PersonCollection.class);
          String addKey = "servlet/com/update";
          String addValue = "Update";
          Properties originProperties = collectionBean.getProperties();
          originProperties.setProperty(addKey, addValue);
          
          PersonCollection otherBean = applicationContext.getBean("pc1", PersonCollection.class);
          assertThat(otherBean.getProperties().getProperty(addKey)).isEqualTo(addValue);
     }
}