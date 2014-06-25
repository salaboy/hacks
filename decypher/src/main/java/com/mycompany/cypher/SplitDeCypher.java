/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.cypher;

/**
 *
 * @author salaboy
 */
public class SplitDeCypher implements DeCypher{

  @Override
  public String decypher(DeCypherParam param) {
    String message = param.getValue();
    
    String even = message.substring(0, (message.length() / 2)+1);
    String odd = message.substring((message.length() / 2)+1, message.length());
    StringBuilder result = new StringBuilder();
    for(int i = 0; i < even.length() ; i ++){
      result.append(even.charAt(i));
      if(odd.length() > i ){
        result.append(odd.charAt(i));
      }
    }
    return result.toString();
  }
  
}
