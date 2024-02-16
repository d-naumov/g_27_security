package de.aittr.g_27_security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class test {

  public static void main(String[] args) {
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    String password = "qwe";
    System.out.println(encoder.encode(password));
  }

}
