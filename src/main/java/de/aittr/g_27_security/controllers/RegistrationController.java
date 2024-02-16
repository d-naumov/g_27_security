package de.aittr.g_27_security.controllers;

import de.aittr.g_27_security.domain.dto.UserRegistrationDto;
import de.aittr.g_27_security.services.UserServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

  // private RegistrationService service;
  private UserServices service;

  public RegistrationController(UserServices service) {
    this.service = service;
  }

  @PostMapping("/register")
  public UserRegistrationDto registerUser(@RequestBody UserRegistrationDto userRegistration) {

    UserRegistrationDto user = service.registerNewUser(userRegistration);
    return user;

  }

}
