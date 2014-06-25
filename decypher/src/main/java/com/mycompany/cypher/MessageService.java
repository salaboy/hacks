/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.cypher;

import java.io.IOException;

/**
 *
 * @author salaboy
 */
public interface MessageService {

  void init() throws IOException;

  String readMessage() throws IOException;

  void writeMessage(String message);
  
  void destroy();
}
