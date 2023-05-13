package com.portfolio.backend.Controller;

import com.portfolio.backend.Entity.Project;
import com.portfolio.backend.Service.ProjectService;
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
@RequestMapping("/project")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:4200/" })
public class ProjectController {

  @Autowired
  ProjectService projectService;

  @GetMapping()
  public ResponseEntity<List<Project>> getProjects() {
    List<Project> projectsList = projectService.getProjects();
    return new ResponseEntity(projectsList, HttpStatus.OK);
  }

  @PostMapping()
  public HttpStatus create(@RequestBody Project project) {
    projectService.save(project);
    return HttpStatus.CREATED;
  }

  @DeleteMapping("/delete/{id}")
  public HttpStatus delete(@PathVariable("id") int id) {
    projectService.delete(id);
    return HttpStatus.OK;
  }

  @PatchMapping("/update")
  public HttpStatus edit(@RequestBody Project project) {
    projectService.edit(project);
    return HttpStatus.OK;
  }

}
