package com.portfolio.backend.Repository;

import com.portfolio.backend.Entity.Education;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends JpaRepository<Education, Integer> {

  List<Education> findByPersonId(Long personId);
}
