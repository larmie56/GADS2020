package com.example.gads2020.repo;

import com.example.gads2020.models.LearningLeaders;
import com.example.gads2020.models.SkillIqLeaders;

import java.util.List;

public interface LeadersRepo {

    List<LearningLeaders> getLearningLeaders();
    List<SkillIqLeaders> getSkillIqLeaders();
}
