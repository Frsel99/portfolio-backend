
package com.portfolio.backend.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Project {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @NotNull
  private String project;

  @NotNull
  private String period;

  @Lob
  @NotNull
  private String description;

  @NotNull
  private String[] images;

  @ManyToOne
  @JoinColumn(name = "project:person_id", insertable = false, updatable = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  private Person person;

  private Long personId;

  public Project() {
  }

  public Project(String proyecto, String period, String descripcion, String[] images,
      Person persona) {
    this.project = proyecto;
    this.period = period;
    this.description = descripcion;
    this.images = images;
    this.person = persona;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getProject() {
    return project;
  }

  public void setProject(String project) {
    this.project = project;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getPeriod() {
    return period;
  }

  public void setPeriod(String period) {
    this.period = period;
  }

  @JsonBackReference
  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  public Long getPersonId() {
    return personId;
  }

  public void setPersonId(Long personId) {
    this.personId = personId;
  }

  public String[] getImages() {
    return images;
  }

  public void setImages(String[] images) {
    this.images = images;
  }

}