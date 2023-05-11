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
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String job;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date start;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date end; 
    
    @NotNull
    @Lob   
    private String description;
    
    private String image;
    
    private String url;
    
    private String company;
    
    private boolean isCurrentJob;
    

    @ManyToOne
    @JoinColumn(name = "persons_id", insertable=false, updatable=false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Person person;
    
    private Long personId;

    public Experience() {
    }

    public Experience(String job, Date start, Date end, String description, String image, String url, String company, boolean isCurrentJob, Person person) {
        this.job = job;
        this.start = start;
        this.end = end;
        this.description = description;
        this.image = image;
        this.url = url;
        this.company = company;
        this.isCurrentJob = isCurrentJob;
        this.person = person;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public boolean isCurrentJob() {
        return isCurrentJob;
    }

    public void setCurrentJob(boolean isCurrentJob) {
        this.isCurrentJob = isCurrentJob;
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


    
    
    
    
}