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
public class DeCypherParam {
   private String value;
   private int extra;

  public DeCypherParam(String value, int extra) {
    this.value = value;
    this.extra = extra;
  }

  public DeCypherParam(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public int getExtra() {
    return extra;
  }
   
   
}
