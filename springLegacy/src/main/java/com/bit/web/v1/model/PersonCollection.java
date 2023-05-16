package com.bit.web.v1.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;


@Getter @Setter @ToString
@RequiredArgsConstructor
public class PersonCollection {
     private List<Person> list;
     private Set<Person> set;
     private Properties properties;
     private Map<Integer, Person> map;
}
