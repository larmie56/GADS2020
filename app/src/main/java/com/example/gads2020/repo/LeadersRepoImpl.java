package com.example.gads2020.repo;

import com.example.gads2020.api.Service;
import com.example.gads2020.models.LearningLeaders;
import com.example.gads2020.models.SkillIqLeaders;

import java.util.List;

public class LeadersRepoImpl implements LeadersRepo {

    Service mService;

    public LeadersRepoImpl(Service service) {
        mService = service;
    }
    @Override
    public List<LearningLeaders> getLearningLeaders() {
        return mService.getLearningLeaders();
    }

    @Override
    public List<SkillIqLeaders> getSkillIqLeaders() {
        return mService.getSkillIqLeaders();
    }
}
