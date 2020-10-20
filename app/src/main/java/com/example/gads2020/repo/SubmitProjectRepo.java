package com.example.gads2020.repo;

import io.reactivex.Completable;
import retrofit2.Call;

public interface SubmitProjectRepo {

    Completable submitProject(String emailAddress, String name, String lastName, String projectLink);
}
