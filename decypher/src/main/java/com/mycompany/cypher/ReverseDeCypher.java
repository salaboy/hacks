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
public class ReverseDeCypher implements DeCypher{

  @Override
  public String decypher(DeCypherParam param) {
    return new StringBuilder(param.getValue()).reverse().toString();
  }
  
}
