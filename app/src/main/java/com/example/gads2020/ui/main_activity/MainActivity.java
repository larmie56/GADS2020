package com.example.gads2020.ui.main_activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.example.gads2020.BuildConfig;
import com.example.gads2020.R;
import com.example.gads2020.adapters.viewpager.ViewPagerHomeAdapter;
import com.example.gads2020.api.Service;
import com.example.gads2020.repo.LeadersRepo;
import com.example.gads2020.repo.LeadersRepoImpl;
import com.example.gads2020.ui.SubmitActivity;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private ViewPager2 mViewPagerHome;
    private MainActivityViewModel mMainActivityViewModel;
    private LeadersRepo mLeadersRepo;
    private FrameLayout mContainer_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContainer_submit = findViewById(R.id.container_submit);
        mContainer_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SubmitActivity.class));
            }
        });
        mViewPagerHome = findViewById(R.id.viewpager_home);
        ViewPagerHomeAdapter viewPagerHomeAdapter = new ViewPagerHomeAdapter(this);
        mViewPagerHome.setAdapter(viewPagerHomeAdapter);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        new TabLayoutMediator(tabLayout, mViewPagerHome, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if (position == 1) {
                    tab.setText("Learning Leaders");
                } else {
                    tab.setText("Skill IQ Leaders");
                }
            }
        }).attach();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient())
                .build();

        Service service = retrofit.create(Service.class);
        mLeadersRepo = new LeadersRepoImpl(service);

        mMainActivityViewModel = new ViewModelProvider(this, getMainActivityViewModelFactory())
                .get(MainActivityViewModel.class);
    }

    public MainActivityViewModelFactory getMainActivityViewModelFactory() {
        return new MainActivityViewModelFactory(mLeadersRepo);
    }
}