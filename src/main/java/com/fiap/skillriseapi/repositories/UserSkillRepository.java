package com.fiap.skillriseapi.repositories;

import com.fiap.skillriseapi.domain.entities.UserSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserSkillRepository extends JpaRepository<UserSkill, Long> {
    List<UserSkill> findByUser_UserId(Long userId);
    List<UserSkill> findBySkill_SkillId(Long skillId);
}
