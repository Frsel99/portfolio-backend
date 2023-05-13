package com.portfolio.backend.Controller;

import com.portfolio.backend.Entity.Education;
import com.portfolio.backend.Service.EducationService;
import java.util.List;
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
@RequestMapping("/education")
@CrossOrigin(origins = { "http://localhost:4200" })
public class EducationController {

  @Autowired
  private EducationService educationService;

  @GetMapping()
  public ResponseEntity<List<Education>> getEducation() {
    List<Education> educationList = educationService.getEducation();
    return new ResponseEntity(educationList, HttpStatus.OK);
  }

  @PostMapping()
  public HttpStatus create(@RequestBody Education education) {
    educationService.save(education);
    return HttpStatus.CREATED;
  }

  @DeleteMapping("/delete/{id}")
  public HttpStatus delete(@PathVariable("id") int id) {
    educationService.delete(id);
    return HttpStatus.OK;
  }

  @PatchMapping("/update")
  public HttpStatus edit(@RequestBody Education education) {
    educationService.save(education);
    return HttpStatus.OK;
  }

}
