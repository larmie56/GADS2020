package com.example.gads2020;

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

import com.example.gads2020.adapters.recycler_view.SkillIqLeadersAdapter;

public class SkillIqLeadersFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_skill_iq_leaders, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MainActivityViewModelFactory factory = ((MainActivity) requireActivity())
                .getMainActivityViewModelFactory();
        MainActivityViewModel mainActivityViewModel = new ViewModelProvider(requireActivity(), factory)
                .get(MainActivityViewModel.class);

        RecyclerView recyclerViewSkillIqLeaders = view.findViewById(R.id.recycler_skill_iq_leaders);
        SkillIqLeadersAdapter skillIqLeadersAdapter =
                new SkillIqLeadersAdapter(mainActivityViewModel.getSkillIqLeaders().getValue(), getContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerViewSkillIqLeaders.setLayoutManager(layoutManager);
        recyclerViewSkillIqLeaders.setAdapter(skillIqLeadersAdapter);
    }
}
