package com.example.gads2020.repo;

import io.reactivex.Completable;
import io.reactivex.Single;
import retrofit2.Call;

public interface SubmitProjectRepo {

    Single<Call<Void>> submitProject(String emailAddress, String name, String lastName, String projectLink);
}
