package com.example.gads2020.ui.submit_activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.gads2020.BuildConfig;
import com.example.gads2020.R;
import com.example.gads2020.api.RetrofitSingleton;
import com.example.gads2020.api.Service;
import com.example.gads2020.repo.SubmitProjectRepo;
import com.example.gads2020.repo.SubmitProjectRepoImpl;
import com.example.gads2020.ui.main_activity.MainActivity;

import retrofit2.Retrofit;

public class SubmitActivity extends AppCompatActivity implements ConfirmSubmissionDialog.ConfirmSubmissionDialogListener {

    private ImageView mBackArrow;
    private EditText mFirstNameEdit;
    private EditText mLastNameEdit;
    private EditText mEmailEdit;
    private EditText mProjectLinkEdit;
    private FrameLayout mSubmitButton;
    private String mFirstName;
    private String mLastName;
    private String mEmail;
    private String mProjectLink;
    private ConfirmSubmissionDialog mDialog;
    private SubmitActivityViewModel mSubmitActivityViewModel;

    @Override
    public void onCreate(Bundle onSavedInstanceState) {
        super.onCreate(onSavedInstanceState);

        setContentView(R.layout.activity_submit);
        initViews();
        attachClickListeners();
    }

    private void attachClickListeners() {
        mBackArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SubmitActivity.this, MainActivity.class));
            }
        });

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeSubmission();
            }
        });
    }

    private void getSubmissionInfo() {
        mFirstName = mFirstNameEdit.getText().toString();
        mLastName = mLastNameEdit.getText().toString();
        mEmail = mEmailEdit.getText().toString();
        mProjectLink = mProjectLinkEdit.getText().toString();
    }

    private void makeSubmission() {
        mDialog = new ConfirmSubmissionDialog();
        mDialog.show(getSupportFragmentManager(), "Confirm Submission");
    }

    private void initViews() {
        mBackArrow = findViewById(R.id.image_back_arrow);
        mFirstNameEdit = findViewById(R.id.edit_first_name);
        mLastNameEdit = findViewById(R.id.edit_last_name);
        mEmailEdit = findViewById(R.id.edit_email);
        mProjectLinkEdit = findViewById(R.id.edit_project_link);
        mSubmitButton = findViewById(R.id.button_submit);
        mSubmitActivityViewModel = new ViewModelProvider(this).get(SubmitActivityViewModel.class);
    }

    @Override
    public void submissionCancelled() {
        mDialog.dismiss();
    }

    @Override
    public void submissionConfirmed() {
        Toast.makeText(this, "Submission Confirmed", Toast.LENGTH_SHORT).show();
        getSubmissionInfo();
        Retrofit retrofit = RetrofitSingleton.getRetrofit(BuildConfig.POST_BASE_URL);
        SubmitProjectRepo repo = new SubmitProjectRepoImpl(retrofit.create(Service.class));
        mSubmitActivityViewModel.submitProject(repo, mEmail, mFirstName, mLastName, mProjectLink);
        mDialog.dismiss();
    }

    private void submissionResult() {

    }
}
