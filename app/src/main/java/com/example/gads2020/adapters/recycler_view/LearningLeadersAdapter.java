package com.example.gads2020.adapters.recycler_view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gads2020.R;
import com.example.gads2020.models.LearningLeaders;
import com.example.gads2020.utils.StringUtil;

import java.util.List;

public class LearningLeadersAdapter extends RecyclerView.Adapter<LearningLeadersAdapter.ViewHolder> {

    private List<LearningLeaders> mLearningLeaders;
    private LayoutInflater mLayoutInflater;

    public LearningLeadersAdapter(List<LearningLeaders> learningLeaders, Context context) {
        mLearningLeaders = learningLeaders;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.learning_leaders_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return mLearningLeaders == null ? 0 : mLearningLeaders.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mLearningLeaderName;
        private TextView mLearningLeaderHour;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mLearningLeaderName = itemView.findViewById(R.id.text_learning_leader_name);
            mLearningLeaderHour = itemView.findViewById(R.id.text_learning_leader_hour);
        }

        public void bind(int position) {
            LearningLeaders learningLeader = mLearningLeaders.get(position);
            mLearningLeaderName.setText(learningLeader.getName());
            mLearningLeaderHour.setText(StringUtil.formatLearningHours(learningLeader.getHours(), learningLeader.getCountry()));
        }
    }
}
