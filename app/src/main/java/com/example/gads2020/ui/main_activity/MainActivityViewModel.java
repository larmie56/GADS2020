package com.example.gads2020.ui.main_activity;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.gads2020.models.LearningLeaders;
import com.example.gads2020.models.SkillIqLeaders;
import com.example.gads2020.repo.LeadersRepo;

import java.util.List;
import java.util.Objects;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivityViewModel extends ViewModel {

    private LeadersRepo mRepo;
    private MutableLiveData<List<LearningLeaders>> mLearningLeadersLiveData = new MutableLiveData<>();
    private MutableLiveData<List<SkillIqLeaders>> mSkillIqLeadersLiveData = new MutableLiveData<>();
    private CompositeDisposable mDisposable = new CompositeDisposable();

    public MainActivityViewModel(LeadersRepo repo) {
        mRepo = repo;
        fetchLearningLeaders();
        fetchSkillIqLeaders();
    }

    private void fetchLearningLeaders() {
        mDisposable.add(mRepo.getLearningLeaders()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<LearningLeaders>>() {
                    @Override
                    public void accept(List<LearningLeaders> learningLeaders) throws Exception {
                        mLearningLeadersLiveData.postValue(learningLeaders);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e("Error", "Fetching error: " + throwable.getMessage());
                    }
                }));
    }

    private void fetchSkillIqLeaders() {
        mDisposable.add(mRepo.getSkillIqLeaders()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<SkillIqLeaders>>() {
                    @Override
                    public void accept(List<SkillIqLeaders> skillIqLeaders) throws Exception {
                        mSkillIqLeadersLiveData.postValue(skillIqLeaders);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e("Error", "Fetching error: " + throwable.getMessage());
                    }
                }));
    }

    public LiveData<List<LearningLeaders>> getLearningLeaders() {
        return mLearningLeadersLiveData;
    }

    public LiveData<List<SkillIqLeaders>> getSkillIqLeaders() {
        return mSkillIqLeadersLiveData;
    }
}
