/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cypher;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author salaboy
 */
public class MessageServiceImpl implements MessageService {

  private Socket socket;
  private String server = "10.112.145.210";
  private int port = 8000;
  private DataOutputStream output = null;
  private BufferedReader input = null;

  public MessageServiceImpl(String server, int port) {
    this.server = server;
    this.port = port;
  }

  @Override
  public void init() throws IOException {
    socket = new Socket(server, port);

  }
  
  @Override
  public void destroy() {
    try {
      input.close();
      output.close();
    } catch (IOException ex) {
      Logger.getLogger(MessageServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  @Override
  public String readMessage() throws IOException {
    input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    while (!input.ready()) {
    }
    return input.readLine();
  }

  @Override
  public void writeMessage(String message) {
      try {
        output = new DataOutputStream(socket.getOutputStream());
        output.writeBytes(message);
      } catch (IOException ex) {
        Logger.getLogger(MessageServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    
  
  }
