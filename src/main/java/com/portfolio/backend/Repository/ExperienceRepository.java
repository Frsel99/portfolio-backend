
package com.portfolio.backend.Repository;

import com.portfolio.backend.Entity.Experience;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Integer> {
  List<Experience> findByPersonId(Long personId);
}
