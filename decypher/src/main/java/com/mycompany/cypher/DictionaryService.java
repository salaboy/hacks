/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cypher;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author salaboy
 */
public class DictionaryService {

  private SortedSet<String> dictionary;

  public void init() throws FileNotFoundException, IOException {
    dictionary = new TreeSet<String>();
    
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/wordsEn.txt")))) {
      String word;
      
      while ((word = reader.readLine()) != null) {
        dictionary.add(word);
      }
    }
    

  }

  public boolean check(String word) {
    return dictionary.contains(word.toLowerCase());
  }
}
