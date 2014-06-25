/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cypher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author salaboy
 */
public class DeCypherAlgorithm {

  public Map<String, DeCypher> decyphers;
  MessageServiceImpl messageService;
  DictionaryService dictionaryService;
  private static int messageNro = 0;

  public DeCypherAlgorithm(Map<String, DeCypher> decyphers, DictionaryService dictionaryService) {
    this.decyphers = decyphers;
    this.dictionaryService = dictionaryService;
  }

  public String decypher(final String encryptedMessage) {
    Map<String, Integer> finalAnswer = new HashMap<String, Integer>();
    
    Map<String, String> results = new LinkedHashMap<String, String>();
    Set<List<String>> powerSet = Helper.powerSet(decyphers.keySet());
    
    
    
    ArrayList<String> reverse1 = new ArrayList<String>();
    reverse1.add("reverse");
    reverse1.add("rotn");
    powerSet.add(reverse1);
    ArrayList<String> reverse2 = new ArrayList<String>();
    reverse2.add("split");
    reverse2.add("rotn");
    powerSet.add(reverse2);
    ArrayList<String> reverse3 = new ArrayList<String>();
    reverse3.add("reverse");
    reverse3.add("split");
    powerSet.add(reverse3);
    ArrayList<String> reverse4 = new ArrayList<String>();
    reverse4.add("rotn");
    reverse4.add("reverse");
    reverse4.add("split");
    powerSet.add(reverse4);
    ArrayList<String> reverse5 = new ArrayList<String>();
    reverse5.add("split");
    reverse5.add("reverse");
    reverse5.add("rotn");
    powerSet.add(reverse5);
    ArrayList<String> reverse6 = new ArrayList<String>();
    reverse6.add("split");
    reverse6.add("rotn");
    reverse6.add("reverse");
    powerSet.add(reverse6);
    ArrayList<String> reverse7 = new ArrayList<String>();
    reverse7.add("reverse");
    reverse7.add("rotn");
    reverse7.add("split");
    powerSet.add(reverse7);
    ArrayList<String> reverse8 = new ArrayList<String>();
    reverse8.add("reverse");
    reverse8.add("split");
    reverse8.add("rotn");
    powerSet.add(reverse8);

 //   System.out.println("Power Set: " + powerSet);
    for (List<String> decypherChain : powerSet) {
      
      int it = 2;
      if (decypherChain.contains("rotn")) {
        it = 26;
      }
      for (int i = 1; i < it; i++) {
        String tempAnswer = encryptedMessage;
        for (String decypher : decypherChain) {
          if (decypher.equals("rotn")) {
            tempAnswer = decyphers.get(decypher).decypher(new DeCypherParam(tempAnswer, i));
          } else {
            tempAnswer = decyphers.get(decypher).decypher(new DeCypherParam(tempAnswer));
          }
        }
   //     results.put("[" + messageNro + " ]->" + decypherChain.toString() + " -> " + i, tempAnswer);
        int countMatch = 0;

        String[] words = tempAnswer.split(" ");
        for (String word : words) {
          if (word.length() >= 3 && dictionaryService.check(word)) {
            countMatch++;
          }
        }
        if (words.length > 1) {
          int half = words.length / 2;
          if (countMatch >= half) {
            finalAnswer.put(tempAnswer, countMatch);
          }
        } else if (countMatch == words.length) {
          finalAnswer.put(tempAnswer, countMatch);
        }

      }

    }

    messageNro++;
//    System.out.println("Results \n\t");
//    for (String key : results.keySet()) {
//      System.out.println("\t Chypers :" + key + " answer: " + results.get(key));
//    }
    String finalKey = "";
    int max = 0;
    for(String key : finalAnswer.keySet()){
      if(finalAnswer.get(key) > max){
        finalKey = key;
      }
    }
    return finalKey;

  }

}
