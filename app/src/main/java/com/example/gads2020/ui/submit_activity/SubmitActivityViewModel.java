package com.example.gads2020.ui.submit_activity;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.gads2020.repo.SubmitProjectRepo;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubmitActivityViewModel extends ViewModel {

    private Disposable mDisposable;
    private MutableLiveData<Boolean> isSuccessful = new MutableLiveData<>();

    public void submitProject(SubmitProjectRepo submitProjectRepo, String emailAddress, String name,
                              String lastName, String projectLink) {
        mDisposable = submitProjectRepo.submitProject(emailAddress, name, lastName, projectLink)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Call<Void>>() {
                    @Override
                    public void accept(Call<Void> voidCall) throws Exception {
                        voidCall.enqueue(new Callback<Void>() {
                            @Override
                            public void onResponse(Call<Void> call, Response<Void> response) {
                                if (response.isSuccessful()) {
                                    isSuccessful.postValue(true);
                                } else {
                                    isSuccessful.postValue(false);
                                }
                            }

                            @Override
                            public void onFailure(Call<Void> call, Throwable t) {
                                isSuccessful.postValue(false);
                            }
                        });
                    }
                });
    }

    public LiveData<Boolean> getIsSuccessful() {
        return isSuccessful;
    }
    @Override
    protected void onCleared() {
        if (mDisposable != null && !mDisposable.isDisposed()) {
            mDisposable.dispose();
        }
    }
}
