package com.example.gads2020.repo;

import com.example.gads2020.models.LearningLeaders;
import com.example.gads2020.models.SkillIqLeaders;

import java.util.List;

import io.reactivex.Single;

public interface LeadersRepo {

    Single<List<LearningLeaders>> getLearningLeaders();
    Single<List<SkillIqLeaders>> getSkillIqLeaders();
}
