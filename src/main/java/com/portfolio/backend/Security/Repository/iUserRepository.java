
package com.portfolio.backend.Security.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.backend.Security.Entity.User;

@Repository
public interface iUserRepository extends JpaRepository<User, Integer> {
  Optional<User> findByNombreUsuario(String nombreUsuario);

  boolean existsByNombreUsuario(String nombreUsuario);

  boolean existsByEmail(String email);
}