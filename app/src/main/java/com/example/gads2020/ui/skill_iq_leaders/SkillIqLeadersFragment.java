package com.example.gads2020.ui.skill_iq_leaders;

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
import com.example.gads2020.adapters.recycler_view.SkillIqLeadersAdapter;
import com.example.gads2020.models.SkillIqLeaders;
import com.example.gads2020.ui.main_activity.MainActivity;
import com.example.gads2020.ui.main_activity.MainActivityViewModel;
import com.example.gads2020.ui.main_activity.MainActivityViewModelFactory;

import java.util.List;

public class SkillIqLeadersFragment extends Fragment {
    List<SkillIqLeaders> mSkillIqLeaders;
    private RecyclerView mRecyclerViewSkillIqLeaders;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_skill_iq_leaders, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerViewSkillIqLeaders = view.findViewById(R.id.recycler_skill_iq_leaders);

        MainActivityViewModelFactory factory = ((MainActivity) requireActivity())
                .getMainActivityViewModelFactory();
        MainActivityViewModel mainActivityViewModel = new ViewModelProvider(requireActivity(), factory)
                .get(MainActivityViewModel.class);
        mainActivityViewModel.getSkillIqLeaders().observe(this, new Observer<List<SkillIqLeaders>>() {
            @Override
            public void onChanged(List<SkillIqLeaders> skillIqLeaders) {
                SkillIqLeadersAdapter skillIqLeadersAdapter =
                        new SkillIqLeadersAdapter(skillIqLeaders, getContext());
                mRecyclerViewSkillIqLeaders.setAdapter(skillIqLeadersAdapter);
            }
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mRecyclerViewSkillIqLeaders.setLayoutManager(layoutManager);
    }
}
