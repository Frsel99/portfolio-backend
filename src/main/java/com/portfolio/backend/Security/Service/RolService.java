
package com.portfolio.backend.Security.Service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.portfolio.backend.Security.Entity.Rol;
import com.portfolio.backend.Security.Enums.RolNombre;
import com.portfolio.backend.Security.Repository.iRolRepository;

@Service
@Transactional
public class RolService {
  @Autowired
  iRolRepository irolRepository;

  public Optional<Rol> getbyRolNombre(RolNombre rolNombre) {
    return irolRepository.findByRolNombre(rolNombre);
  }

  public void save(Rol rol) {
    irolRepository.save(rol);
  }
}