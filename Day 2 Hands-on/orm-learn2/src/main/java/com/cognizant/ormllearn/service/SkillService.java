package com.cognizant.ormllearn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormllearn.model.Skill;
import com.cognizant.ormllearn.repository.SkillRepository;

@Service
public class SkillService {
	@Autowired
	private SkillRepository skillRepository;

	public Skill getSkillById(int id) {
		return skillRepository.findById(id);
	}

}