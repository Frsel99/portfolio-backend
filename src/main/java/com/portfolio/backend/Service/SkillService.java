package com.portfolio.backend.Service;

import com.portfolio.backend.Entity.Skill;
import com.portfolio.backend.Repository.SkillRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SkillService {
  @Autowired
  public SkillRepository skillRepository;

  public List<Skill> getSkills() {
    return skillRepository.findAll();
  }

  public Skill getOne(int id) {
    return skillRepository.findById(id).orElse(null);
  }

  public void save(Skill skil) {
    skillRepository.save(skil);
  }

  public void delete(int id) {
    skillRepository.deleteById(id);
  }

  public void edit(Skill skill) {
    skillRepository.save(skill);
  }

  public List<Skill> findByPersonId(Long personId) {
    return skillRepository.findByPersonId(personId);
  }
}
