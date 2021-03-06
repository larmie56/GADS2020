package com.example.gads2020.ui.main_activity;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.gads2020.repo.LeadersRepo;
import com.example.gads2020.ui.main_activity.MainActivityViewModel;

public class MainActivityViewModelFactory implements ViewModelProvider.Factory {
    private LeadersRepo mRepo;

    public MainActivityViewModelFactory(LeadersRepo repo) {
        mRepo = repo;
    }
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new MainActivityViewModel(mRepo);
    }
}
