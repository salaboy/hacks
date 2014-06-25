/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cypher;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author salaboy
 */
public class Helper {

  public static <T> Set<List<T>> powerSet(Set<T> originalSet) {
    Set<List<T>> sets = new LinkedHashSet<List<T>>();
    if (originalSet.isEmpty()) {
      sets.add(new ArrayList<T>());
      return sets;
    }
    List<T> list = new ArrayList<T>(originalSet);
    T head = list.get(0);
    Set<T> rest = new LinkedHashSet<T>(list.subList(1, list.size()));
    for (List<T> set : powerSet(rest)) {
      List<T> newSet = new ArrayList<T>();
      newSet.add(head);
      newSet.addAll(set);
      sets.add(newSet);
      sets.add(set);
    }
    return sets;
  }
  
  public static <T> Set<List<T>> allCombinations(Set<T> originalSet){
    Set<List<T>> sets = new LinkedHashSet<List<T>>();
//    sets.add(new ArrayList<T>());
//    List<T> list = new ArrayList<T>(originalSet);
//    for(int i = 0; i < list.size(); i ++){
//      sets.add()
//    }
    
    return sets;
  }
}
