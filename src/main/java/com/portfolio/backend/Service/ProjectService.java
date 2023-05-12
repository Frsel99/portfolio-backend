package com.portfolio.backend.Service;

import com.portfolio.backend.Entity.Project;
import com.portfolio.backend.Repository.ProjectRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional 
public class ProjectService {

  @Autowired
  ProjectRepository projectRepository;

  public List<Project> getProjects() {
    return projectRepository.findAll();
  }

  public void save(Project project) {
    projectRepository.save(project);
  }

  public void delete(int id) {
    projectRepository.deleteById(id);
  }

  public void edit(Project project) {
    projectRepository.save(project);
  }

}