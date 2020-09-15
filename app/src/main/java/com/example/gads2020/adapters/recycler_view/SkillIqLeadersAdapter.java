package com.example.gads2020.adapters.recycler_view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gads2020.R;
import com.example.gads2020.models.SkillIqLeaders;
import com.example.gads2020.utils.StringUtil;

import java.util.List;

public class SkillIqLeadersAdapter extends RecyclerView.Adapter<SkillIqLeadersAdapter.ViewHolder> {

    private List<SkillIqLeaders> mSkillIqLeaders;
    private LayoutInflater mLayoutInflater;

    public SkillIqLeadersAdapter(List<SkillIqLeaders> skillIqLeaders, Context context) {
        mSkillIqLeaders = skillIqLeaders;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.skill_iq_leaders_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return mSkillIqLeaders == null ? 0 : mSkillIqLeaders.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mSkillIqLeaderName;
        private TextView mSkillIqLeaderScore;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mSkillIqLeaderName = itemView.findViewById(R.id.text_skill_iq_leader_name);
            mSkillIqLeaderScore = itemView.findViewById(R.id.text_skill_iq_leader_score);
        }

        public void bind(int position) {
            SkillIqLeaders skillIqLeader = mSkillIqLeaders.get(position);

            mSkillIqLeaderName.setText(skillIqLeader.getName());
            mSkillIqLeaderScore.setText(StringUtil.formatSkillIqScore(skillIqLeader.getScore(), skillIqLeader.getCountry()));
        }
    }
}
