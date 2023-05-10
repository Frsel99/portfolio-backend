package com.portfolio.backend.Security.Entity;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MainUser implements UserDetails {

  private String name;
  private String username;
  private String email;
  private String password;
  private Collection<? extends GrantedAuthority> authorities;

  public MainUser(String name, String username, String email, String password,
      Collection<? extends GrantedAuthority> authorities) {
    this.name = name;
    this.username = username;
    this.email = email;
    this.password = password;
    this.authorities = authorities;
  }

  public static MainUser build(User usuario) {
    List<GrantedAuthority> authorities = usuario.getRoles().stream()
        .map(rol -> new SimpleGrantedAuthority(rol.getRolName().name())).collect(Collectors.toList());
    return new MainUser(usuario.getName(), usuario.getUsername(), usuario.getEmail(),
        usuario.getPassword(), authorities);
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  @Override
  public String getPassword() {
    return password;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  @Override
  public String getUsername() {
    return username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

}