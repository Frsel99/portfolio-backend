package com.portfolio.backend.Controller;

import com.portfolio.backend.Entity.Experience;
import com.portfolio.backend.Service.ExperienceService;
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
@RequestMapping("experience")
@CrossOrigin(origins = { "http://localhost:4200", "https://portfolio-frontend-e30d6.web.app" })
public class ExperienceController {

  @Autowired
  ExperienceService experienceService;

  @GetMapping("")
  public ResponseEntity<List<Experience>> getList() {
    List<Experience> list = experienceService.list();
    return new ResponseEntity(list, HttpStatus.OK);
  }

  @GetMapping("/person/{id}")
  public List<Experience> findByPersonId(@PathVariable Long id) {
    return experienceService.findByPersonId(id);
  }

  @PostMapping()
  public HttpStatus create(@RequestBody Experience experience) {
    if(StringUtils.isBlank(experience.getJob()) || StringUtils.isBlank(experience.getDescription()) || StringUtils.isBlank(experience.getPeriod()) ) {
      return HttpStatus.BAD_REQUEST;
    }
    experienceService.save(experience);
    return HttpStatus.CREATED;
  }

  @DeleteMapping("/delete/{id}")
  public HttpStatus delete(@PathVariable("id") int id) {
    experienceService.delete(id);
    return HttpStatus.OK;
  }

  @PatchMapping("/update")
  public HttpStatus edit(@RequestBody Experience experience) {
    if(StringUtils.isBlank(experience.getJob()) || StringUtils.isBlank(experience.getDescription()) || StringUtils.isBlank(experience.getPeriod()) ) {
      return HttpStatus.BAD_REQUEST;
    }
    experienceService.save(experience);
    return HttpStatus.OK;
  }
}
