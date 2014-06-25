/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.cypher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author salaboy
 */
public class MockMessageServiceImpl implements MessageService {

  private List<String> messages = new ArrayList<String>()
  {{
//        add("this is the first no encrypted message");
//        add(new StringBuilder("this is the first no encrypted message").reverse().toString());
//        add("aabb");
//        add("tehm");
          add("M aei akynm spr");
          
//        add("hi my name is abductor");
//        add("ti stefrto nrpe esghsi h is oecytdmsae");
  }};
  private int counter = 0;
  @Override
  public void init() throws IOException {
    this.counter = 0;
  }

  @Override
  public String readMessage() throws IOException {
    
    String message = messages.get(counter);
    this.counter++;
    return message;
  }

  @Override
  public void writeMessage(String message) {
    System.out.println("Decrypeted message: "+ message);
  } 

  @Override
  public void destroy() {
    //nothing to do here
  }
  
}
