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
public class RotNDeCypher implements DeCypher {

  @Override
  public String decypher(DeCypherParam param) {
    
      String message = param.getValue();
      int rot = param.getExtra();
      StringBuilder builder = new StringBuilder();
      for (int i = 0; i < message.length(); i++) {
        char charAt = message.charAt(i);

        int finalValue = 0;
        if (isUpperCase(charAt)) {
          finalValue = charAt + rot;
          if (finalValue > 'Z') {
            int middle = finalValue - 'Z';
            finalValue = 'A' + middle - 1;
          }
        } else if (isLowerCase(charAt)) {
          finalValue = charAt + rot;
          if (finalValue > 'z') {
            int middle = finalValue - 'z';
            finalValue = 'a' + middle - 1;
          }

        } else {
          finalValue = charAt;
        }
        builder.append((char) finalValue);
      }

    return builder.toString();
  }

  private boolean isUpperCase(int value) {
    return value >= 'A' && value <= 'Z';

  }

  private boolean isLowerCase(int value) {
    return value >= 'a' && value <= 'z';

  }

}
