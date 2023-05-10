
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
  UserService userService;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User usuario = userService.getByUsername(username).get();
    return MainUser.build(usuario);
  }

}