package com.example.gads2020.ui.learning_leaders;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gads2020.R;
import com.example.gads2020.adapters.recycler_view.LearningLeadersAdapter;
import com.example.gads2020.ui.main_activity.MainActivity;
import com.example.gads2020.ui.main_activity.MainActivityViewModel;
import com.example.gads2020.ui.main_activity.MainActivityViewModelFactory;

public class LearningLeadersFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_learning_leaders, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MainActivityViewModelFactory factory = ((MainActivity) requireActivity()).
                getMainActivityViewModelFactory();
        MainActivityViewModel mainActivityViewModel = new ViewModelProvider(requireActivity(), factory)
                .get(MainActivityViewModel.class);

        RecyclerView recyclerViewLearningLeaders = view.findViewById(R.id.recycler_learning_leaders);
        LearningLeadersAdapter learningLeadersAdapter =
                new LearningLeadersAdapter(mainActivityViewModel.getLearningLeaders().getValue(), getContext());

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerViewLearningLeaders.setLayoutManager(layoutManager);
        recyclerViewLearningLeaders.setAdapter(learningLeadersAdapter);
    }


}