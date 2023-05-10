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
@CrossOrigin(origins = { "https://portfoliomanuacosta.web.app", "http://localhost:4200" })
public class AuthController {
  @Autowired
  PasswordEncoder passwordEncoder;
  @Autowired
  AuthenticationManager authenticationManager;
  @Autowired
  UserService usuarioService;
  @Autowired
  RolService rolService;
  @Autowired
  JwtProvider jwtProvider;

  @PostMapping("/nuevo")
  public ResponseEntity<?> nuevo(@Valid @RequestBody NewUser nuevoUsuario, BindingResult bindingResult) {
    if (bindingResult.hasErrors())
      return new ResponseEntity(new Message("Campos mal puestos o email invalido"), HttpStatus.BAD_REQUEST);

    if (usuarioService.existsByNombreUsuario(nuevoUsuario.getNombreUsuario()))
      return new ResponseEntity(new Message("Ese nombre de usuario ya existe"), HttpStatus.BAD_REQUEST);

    if (usuarioService.existsByEmail(nuevoUsuario.getEmail()))
      return new ResponseEntity(new Message("Ese email ya existe"), HttpStatus.BAD_REQUEST);

    User usuario = new User(nuevoUsuario.getNombre(), nuevoUsuario.getNombreUsuario(),
        nuevoUsuario.getEmail(), passwordEncoder.encode(nuevoUsuario.getPassword()));

    Set<Rol> roles = new HashSet<>();
    roles.add(rolService.getbyRolName(RolName.ROLE_USER).get());

    if (nuevoUsuario.getRoles().contains("admin"))
      roles.add(rolService.getbyRolName(RolName.ROLE_ADMIN).get());
    usuario.setRoles(roles);
    usuarioService.save(usuario);

    return new ResponseEntity(new Message("Usuario guardado"), HttpStatus.CREATED);
  }

  @PostMapping("/login")
  public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUser loginUsuario, BindingResult bindingResult) {
    if (bindingResult.hasErrors())
      return new ResponseEntity(new Message("Campos mal puestos"), HttpStatus.BAD_REQUEST);

    Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
        loginUsuario.getNombreUsuario(), loginUsuario.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);

    String jwt = jwtProvider.generateToken(authentication);

    UserDetails userDetails = (UserDetails) authentication.getPrincipal();

    JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());

    return new ResponseEntity(jwtDto, HttpStatus.OK);
  }
}