package com.example.gads2020.api;

import com.example.gads2020.models.LearningLeaders;
import com.example.gads2020.models.SkillIqLeaders;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Service {

    @GET("/api/hours")
    Single<List<LearningLeaders>> getLearningLeaders();

    @GET("/api/skilliq")
    Single<List<SkillIqLeaders>> getSkillIqLeaders();

    @POST("https://docs.google.com/forms/d/e/1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    @FormUrlEncoded
    Single<Call<Void>> submitProject(@Field(" entry.1824927963") String emailAddress,
                              @Field("entry.1877115667") String name,
                              @Field("entry.2006916086") String lastName,
                              @Field("entry.284483984") String projectLink);

}
