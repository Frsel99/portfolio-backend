
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
  iUserRepository iuserRepository;

  public Optional<User> getByUsername(String username) {
    return iuserRepository.findByUsername(username);
  }

  public boolean existsByUsername(String username) {
    return iuserRepository.existsByUsername(username);
  }

  public boolean existsByEmail(String email) {
    return iuserRepository.existsByEmail(email);
  }

  public void save(User user) {
    iuserRepository.save(user);
  }
}