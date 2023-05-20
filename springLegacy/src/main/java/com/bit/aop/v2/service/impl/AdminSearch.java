package com.bit.aop.v2.service.impl;

import com.bit.aop.v2.service.Search;
import org.springframework.stereotype.Component;

@Component
public class AdminSearch implements Search {
     @Override
     public void fileSearch() {
          System.out.println("AdminSearch.fileSearch");
     }
     
     @Override
     public void xmlParsing() {
          System.out.println("AdminSearch.xmlParsing");
     }
     
     @Override
     public void domSaxSearch() {
          System.out.println("AdminSearch.domSaxSearch");
//          throw new ArrayIndexOutOfBoundsException();
     }
}
