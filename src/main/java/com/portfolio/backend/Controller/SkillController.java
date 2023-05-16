package com.portfolio.backend.Controller;

import com.portfolio.backend.Entity.Skill;
import com.portfolio.backend.Service.SkillService;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/skill")
@CrossOrigin(origins = { "http://localhost:4200", "https://portfolio-frontend-e30d6.web.app" })
public class SkillController {

  @Autowired
  private SkillService skillService;

  @GetMapping()
  public ResponseEntity<List<Skill>> getSkills() {
    List<Skill> skillsList = skillService.getSkills();
    return new ResponseEntity(skillsList, HttpStatus.OK);
  }

  @PostMapping()
  public HttpStatus save(@RequestBody Skill skill) {
    if(StringUtils.isBlank(skill.getSkill())) {
      return HttpStatus.BAD_REQUEST;
    }
    skillService.save(skill);
    return HttpStatus.CREATED;
  }

  @DeleteMapping("/delete/{id}")
  public HttpStatus delete(@PathVariable("id") int id) {
    skillService.delete(id);
    return HttpStatus.OK;
  }

  @PatchMapping("/update")
  public HttpStatus edit(@RequestBody Skill skill) {
    if(StringUtils.isBlank(skill.getSkill())) {
      return HttpStatus.BAD_REQUEST;
    }
    skillService.save(skill);
    return HttpStatus.OK;
  }

}
