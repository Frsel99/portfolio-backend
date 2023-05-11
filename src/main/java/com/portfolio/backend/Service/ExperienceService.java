package com.portfolio.backend.Service;

import com.portfolio.backend.Entity.Experience;
import com.portfolio.backend.Repository.ExperienceRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ExperienceService {

  @Autowired
  ExperienceRepository experienceRepository;

  public List<Experience> list() {
    return experienceRepository.findAll();
  }
  
  public void save(Experience experience) {
    experienceRepository.save(experience);
  }

  public void delete(int id) {
    experienceRepository.deleteById(id);
  }

  public void edit(Experience experience) {
    experienceRepository.save(experience);
  }

  public List<Experience> findByPersonId(Long personId) {
    return experienceRepository.findByPersonId(personId);
  }

}
