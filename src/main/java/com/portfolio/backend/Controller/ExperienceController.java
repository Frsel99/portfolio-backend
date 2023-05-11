package com.portfolio.backend.Controller;

import com.portfolio.backend.Entity.Experience;
import com.portfolio.backend.Service.ExperienceService;
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
@RequestMapping("experience")
@CrossOrigin(origins = { "http://localhost:4200" })
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

  @GetMapping("/detail/{id}")
  public ResponseEntity<Experience> getDetails(@PathVariable("id") int id) {
    Experience experience = experienceService.getOne(id);
    return new ResponseEntity(experience, HttpStatus.OK);
  }

  @PostMapping()
  public void create(@RequestBody Experience experience) {
    experienceService.save(experience);
  }

  @DeleteMapping("/delete/{id}")
  public void delete(@PathVariable("id") int id) {
    experienceService.delete(id);
  }

  @PutMapping("/update")
  public void edit(@RequestBody Experience experience) {
    experienceService.save(experience);
  }
}
