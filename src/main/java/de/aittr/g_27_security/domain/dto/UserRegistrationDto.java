package de.aittr.g_27_security.domain.dto;

public class UserRegistrationDto {
  private int id;
  private String username;
  private String password;

  public String getUsername() {
    return username;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
