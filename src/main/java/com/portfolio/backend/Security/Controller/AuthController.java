//el que se comunica con el front
package com.portfolio.backend.Security.Controller;

import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.backend.Security.Dto.JwtDto;
import com.portfolio.backend.Security.Dto.LoginUser;
import com.portfolio.backend.Security.Dto.NewUser;
import com.portfolio.backend.Security.Entity.Rol;
import com.portfolio.backend.Security.Entity.User;
import com.portfolio.backend.Security.Enums.RolName;
import com.portfolio.backend.Security.Jwt.JwtProvider;
import com.portfolio.backend.Security.Service.RolService;
import com.portfolio.backend.Security.Service.UserService;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = { "http://localhost:4200" })
public class AuthController {
  @Autowired
  PasswordEncoder passwordEncoder;
  @Autowired
  AuthenticationManager authenticationManager;
  @Autowired
  UserService userService;
  @Autowired
  RolService rolService;
  @Autowired
  JwtProvider jwtProvider;

  @PostMapping("/")
  public ResponseEntity<?> create(@Valid @RequestBody NewUser newUser, BindingResult bindingResult) {
    if (bindingResult.hasErrors())
      return new ResponseEntity(new Message("Invalid fields"), HttpStatus.BAD_REQUEST);

    if (userService.existsByUsername(newUser.getUsername()))
      return new ResponseEntity(new Message("Username already exist"), HttpStatus.BAD_REQUEST);

    if (userService.existsByEmail(newUser.getEmail()))
      return new ResponseEntity(new Message("Email already exist"), HttpStatus.BAD_REQUEST);

    User user = new User(newUser.getName(), newUser.getUsername(),
        newUser.getEmail(), passwordEncoder.encode(newUser.getPassword()));

    Set<Rol> roles = new HashSet<>();
    roles.add(rolService.getbyRolName(RolName.ROLE_USER).get());

    if (newUser.getRoles().contains("admin"))
      roles.add(rolService.getbyRolName(RolName.ROLE_ADMIN).get());
    user.setRoles(roles);
    userService.save(user);

    return new ResponseEntity(new Message("User saved"), HttpStatus.CREATED);
  }

  @PostMapping("/login")
  public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUser loginUser, BindingResult bindingResult) {
    if (bindingResult.hasErrors())
      return new ResponseEntity(new Message("Invalid fields"), HttpStatus.BAD_REQUEST);

    Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
        loginUser.getUsername(), loginUser.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);

    String jwt = jwtProvider.generateToken(authentication);

    UserDetails userDetails = (UserDetails) authentication.getPrincipal();

    JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());

    return new ResponseEntity(jwtDto, HttpStatus.OK);
  }
}