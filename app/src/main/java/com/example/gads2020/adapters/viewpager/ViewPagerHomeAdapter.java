package com.example.gads2020.adapters.viewpager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.gads2020.ui.learning_leaders.LearningLeadersFragment;
import com.example.gads2020.ui.skill_iq_leaders.SkillIqLeadersFragment;

public class ViewPagerHomeAdapter extends FragmentStateAdapter {

    public ViewPagerHomeAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return position == 0 ? new LearningLeadersFragment() : new SkillIqLeadersFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
