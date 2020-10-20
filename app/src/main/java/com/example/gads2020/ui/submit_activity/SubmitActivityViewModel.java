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

public class SubmitActivityViewModel extends ViewModel {

    private Disposable mDisposable;
    private MutableLiveData<Boolean> isSuccessful = new MutableLiveData<>();

    public void submitProject(SubmitProjectRepo submitProjectRepo, String emailAddress, String name,
                              String lastName, String projectLink) {
        mDisposable = submitProjectRepo.submitProject(emailAddress, name, lastName, projectLink)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action() {
                    @Override
                    public void run() throws Exception {
                        isSuccessful.postValue(true);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        isSuccessful.postValue(false);
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
