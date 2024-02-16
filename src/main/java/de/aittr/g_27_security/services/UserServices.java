package de.aittr.g_27_security.services;

import de.aittr.g_27_security.domain.Role;
import de.aittr.g_27_security.domain.User;
import de.aittr.g_27_security.domain.dto.UserRegistrationDto;
import de.aittr.g_27_security.repositories.RoleRepository;
import de.aittr.g_27_security.repositories.UserRepository;
import java.util.Collections;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServices implements UserDetailsService {

  private UserRepository repository;
  private RoleRepository roleRepository;
  private BCryptPasswordEncoder encoder;

  public UserServices(UserRepository repository, RoleRepository roleRepository,
      BCryptPasswordEncoder encoder) {
    this.repository = repository;
    this.roleRepository = roleRepository;
    this.encoder = encoder;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = repository.findByUsername(username);
    if (user == null) {
      throw new UsernameNotFoundException("User not found!");
    }
    return user;
  }

  public UserRegistrationDto registerNewUser(UserRegistrationDto userRegistration) {
    User existingUser = repository.findByUsername(userRegistration.getUsername());
    if (existingUser != null) {
      throw new RuntimeException(
          "User with username " + userRegistration.getUsername() + " already exists!");
    }

    User newUser = new User();
    newUser.setUsername(userRegistration.getUsername());
    newUser.setPassword(encoder.encode(userRegistration.getPassword()));

    // По умолчанию присваиваем роль "USER"
    Role userRole = roleRepository.findByName("ROLE_USER");
    newUser.setRoles(Collections.singleton(userRole));


   newUser =  repository.save(newUser);

   userRegistration.setId(newUser.getId());
   userRegistration.setPassword("password is hidden");

   return userRegistration;

  }

}
