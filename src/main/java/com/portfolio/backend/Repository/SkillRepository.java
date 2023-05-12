
package com.portfolio.backend.Repository;

import com.portfolio.backend.Entity.Skill;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer> {
  List<Skill> findByPersonId(Long personId);
}
