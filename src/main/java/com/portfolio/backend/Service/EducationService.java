package com.portfolio.backend.Service;

import com.portfolio.backend.Entity.Education;
import com.portfolio.backend.Repository.EducationRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EducationService {

  @Autowired
  public EducationRepository educationRepository;

  public List<Education> getEducation() {
    return educationRepository.findAll();
  }

  public void save(Education education) {
    educationRepository.save(education);
  }

  public void delete(int id) {
    educationRepository.deleteById(id);
  }

  public void edit(Education education) {
    educationRepository.save(education);
  }

}
