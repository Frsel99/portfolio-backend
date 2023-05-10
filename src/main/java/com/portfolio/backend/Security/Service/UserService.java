
package com.portfolio.backend.Security.Service;

import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.backend.Security.Entity.User;
import com.portfolio.backend.Security.Repository.iUserRepository;

@Service
@Transactional
public class UserService {
  @Autowired
  iUserRepository iusuarioRepository;

  public Optional<User> getByNombreUsuario(String nombreUsuario) {
    return iusuarioRepository.findByNombreUsuario(nombreUsuario);
  }

  public boolean existsByNombreUsuario(String nombreUsuario) {
    return iusuarioRepository.existsByNombreUsuario(nombreUsuario);
  }

  public boolean existsByEmail(String email) {
    return iusuarioRepository.existsByEmail(email);
  }

  public void save(User usuario) {
    iusuarioRepository.save(usuario);
  }
}