/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cypher;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author salaboy
 */
public class Main {
  
  private static MessageService messageService; 
    
  private static DictionaryService dictionaryService;
  //MessageService messageService = new MessageServiceImpl("192.168.0.3",8000);

  public static void main(String[] args) throws IOException {

    Map<String, DeCypher> deCyphers = new HashMap<String, DeCypher>(3);
    deCyphers.put("reverse", new ReverseDeCypher());
    deCyphers.put("split", new SplitDeCypher());
    deCyphers.put("rotn", new RotNDeCypher());

    messageService = new MessageServiceImpl("10.40.148.242", 8000);
    messageService.init();
    dictionaryService = new DictionaryService();
    dictionaryService.init();
    DeCypherAlgorithm deCypherAlgorithm = new DeCypherAlgorithm(deCyphers, dictionaryService);
    int r = 0;
    while (true) {
      System.out.println("-----------------------------------");

      String encryptedMessage = messageService.readMessage();
      System.out.println("Round :" + r + " -> Encrypted: " + encryptedMessage);

      String decryptedMessage = deCypherAlgorithm.decypher(encryptedMessage);
      messageService.writeMessage(decryptedMessage);
      System.out.println("-----------------------------------> " + decryptedMessage);
      r++;
    }
  }

  public static void attachShutDownHook() {
    Runtime.getRuntime().addShutdownHook(new Thread() {
      @Override
      public void run() {
        System.out.println("Shutting down...");
        messageService.destroy();
        
      }
    });
    System.out.println("Shut Down Hook Attached.");
  }

}
