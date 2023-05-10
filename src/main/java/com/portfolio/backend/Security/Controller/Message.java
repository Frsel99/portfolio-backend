//controla los mensajes
package com.portfolio.backend.Security.Controller;

public class Message {
  private String mensaje;

  // Constructor

  public Message() {
  }

  public Message(String mensaje) {
    this.mensaje = mensaje;
  }
  // Getter y Setter

  public String getMensaje() {
    return mensaje;
  }

  public void setMensaje(String mensaje) {
    this.mensaje = mensaje;
  }

}