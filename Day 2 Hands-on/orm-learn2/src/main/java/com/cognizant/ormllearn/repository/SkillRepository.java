package com.cognizant.ormllearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.ormllearn.model.Skill;

public interface SkillRepository extends JpaRepository<Skill, String> {
	Skill findById(int id);

}
