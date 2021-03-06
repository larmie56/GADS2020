package com.example.gads2020.repo;

import com.example.gads2020.api.Service;

import io.reactivex.Completable;
import io.reactivex.Single;
import retrofit2.Call;

public class SubmitProjectRepoImpl implements SubmitProjectRepo {
    private Service mService;

    public SubmitProjectRepoImpl(Service service) {
        mService = service;
    }
    @Override
    public Single<Call<Void>> submitProject(String emailAddress, String name, String lastName, String projectLink) {
        return mService.submitProject(emailAddress, name, lastName, projectLink);
    }
}
