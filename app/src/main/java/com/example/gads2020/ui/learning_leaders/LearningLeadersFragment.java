package com.example.gads2020.ui.learning_leaders;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gads2020.R;
import com.example.gads2020.adapters.recycler_view.LearningLeadersAdapter;
import com.example.gads2020.models.LearningLeaders;
import com.example.gads2020.ui.main_activity.MainActivity;
import com.example.gads2020.ui.main_activity.MainActivityViewModel;
import com.example.gads2020.ui.main_activity.MainActivityViewModelFactory;

import java.util.List;

public class LearningLeadersFragment extends Fragment {

    private RecyclerView mRecyclerViewLearningLeaders;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_learning_leaders, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerViewLearningLeaders = view.findViewById(R.id.recycler_learning_leaders);

        MainActivityViewModelFactory factory = ((MainActivity) requireActivity()).
                getMainActivityViewModelFactory();
        MainActivityViewModel mainActivityViewModel = new ViewModelProvider(requireActivity(), factory)
                .get(MainActivityViewModel.class);
        mainActivityViewModel.getLearningLeaders().observe(this, new Observer<List<LearningLeaders>>() {
            @Override
            public void onChanged(List<LearningLeaders> learningLeaders) {
                LearningLeadersAdapter learningLeadersAdapter =
                        new LearningLeadersAdapter(learningLeaders, getContext());
                mRecyclerViewLearningLeaders.setAdapter(learningLeadersAdapter);
            }
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mRecyclerViewLearningLeaders.setLayoutManager(layoutManager);

    }


}