package com.example.gads2020.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gads2020.R;
import com.example.gads2020.ui.main_activity.MainActivity;

public class SubmitActivity extends AppCompatActivity {

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

    @Override
    public void onCreate(Bundle onSavedInstanceState) {
        super.onCreate(onSavedInstanceState);

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
                getSubmissionInfo();
            }
        });
    }

    private void getSubmissionInfo() {
        mFirstName = mFirstNameEdit.getText().toString();
        mLastName = mLastNameEdit.getText().toString();
        mEmail = mEmailEdit.getText().toString();
        mProjectLink = mProjectLinkEdit.getText().toString();
    }

    private void initViews() {
        mBackArrow = findViewById(R.id.image_back_arrow);
        mFirstNameEdit = findViewById(R.id.edit_first_name);
        mLastNameEdit = findViewById(R.id.edit_last_name);
        mEmailEdit = findViewById(R.id.edit_email);
        mProjectLinkEdit = findViewById(R.id.edit_project_link);
        mSubmitButton = findViewById(R.id.button_submit);
    }
}
