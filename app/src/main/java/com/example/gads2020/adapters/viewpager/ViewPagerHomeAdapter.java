package com.example.gads2020;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

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
