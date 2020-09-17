package com.example.gads2020.api;

import com.example.gads2020.models.LearningLeaders;
import com.example.gads2020.models.SkillIqLeaders;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface Service {

    @GET("/api/hours")
    Single<List<LearningLeaders>> getLearningLeaders();

    @GET("/api/skilliq")
    Single<List<SkillIqLeaders>> getSkillIqLeaders();
    
}
