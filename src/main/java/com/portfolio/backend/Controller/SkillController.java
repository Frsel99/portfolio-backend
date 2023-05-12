package com.portfolio.backend.Controller;

import com.portfolio.backend.Entity.Skill;
import com.portfolio.backend.Service.SkillService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/skills")
@CrossOrigin(origins = { "http://localhost:4200" })
public class SkillController {

  @Autowired
  private SkillService skillService;

  @GetMapping()
  public ResponseEntity<List<Skill>> getSkills() {
    List<Skill> skillsList = skillService.getSkills();
    return new ResponseEntity(skillsList, HttpStatus.OK);
  }

  @PostMapping()
  public void save(@RequestBody Skill skill) {
    skillService.save(skill);
  }

  @DeleteMapping("/delete/{id}")
  public void delete(@PathVariable("id") int id) {
    skillService.delete(id);
  }

  @PutMapping("/update")
  public void edit(@RequestBody Skill habi) {
    skillService.save(habi);
  }

}