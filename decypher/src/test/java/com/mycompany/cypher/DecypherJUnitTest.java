/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cypher;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author salaboy
 */
public class DecypherJUnitTest {

  public DecypherJUnitTest() {
  }

  @BeforeClass
  public static void setUpClass() {
  }

  @AfterClass
  public static void tearDownClass() {
  }

  @Before
  public void setUp() {
  }

  @After
  public void tearDown() {
  }

  @Test
  public void hello() throws IOException {
    Map<String, DeCypher> deCyphers = new HashMap<String, DeCypher>(3);
    deCyphers.put("reverse", new ReverseDeCypher());
    deCyphers.put("split", new SplitDeCypher());
    deCyphers.put("rotn", new RotNDeCypher());

    MessageService messageService = new MockMessageServiceImpl();
    DictionaryService dictionaryService = new DictionaryService();
    dictionaryService.init();
    DeCypherAlgorithm deCypherAlgorithm = new DeCypherAlgorithm(deCyphers, dictionaryService);
    
    
      System.out.println("-----------------------------------");

      String encryptedMessage = messageService.readMessage();
    
      String[] words = encryptedMessage.split(" ");
      int countMatch = 0;
      for (String word : words) {

        if (dictionaryService.check(word)) {
          countMatch++;
        }
      }
      if(words.length > 1){
          int half = words.length / 2;
          if (countMatch > half) {
            messageService.writeMessage(encryptedMessage);
          }
        }else if (countMatch == words.length){
          messageService.writeMessage(encryptedMessage);
        }

      String decryptedMessage = deCypherAlgorithm.decypher(encryptedMessage);
      messageService.writeMessage(decryptedMessage);
      System.out.println("-----------------------------------");
     
    
  }

}
