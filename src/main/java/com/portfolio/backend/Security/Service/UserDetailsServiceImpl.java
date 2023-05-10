
package com.portfolio.backend.Security.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.portfolio.backend.Security.Entity.User;
import com.portfolio.backend.Security.Entity.MainUser;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  @Autowired
  UserService usuarioService;

  @Override
  public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
    User usuario = usuarioService.getByNombreUsuario(nombreUsuario).get();
    return MainUser.build(usuario);
  }

}