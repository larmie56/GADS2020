package com.example.gads2020.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.example.gads2020.R;

public class ConfirmSubmissionDialog extends DialogFragment {

    private ConfirmSubmissionDialogListener mListener;

    private ImageView mCancelImage;
    private Button mConfirmButton;

    interface ConfirmSubmissionDialogListener {
        void submissionCancelled();
        void submissionConfirmed();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(requireActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();

        View dialogView = inflater.inflate(R.layout.dialog_confirm_submission, null);

        mCancelImage = dialogView.findViewById(R.id.image_cancel);
        mConfirmButton = dialogView.findViewById(R.id.button_confirm);

        attachListeners();

        dialog.setView(dialogView);

        return dialog.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            mListener = (ConfirmSubmissionDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException("Calling class must implement " +
                    "ConfirmSubmissionDialogListener interface");
        }
    }

    private void attachListeners() {
        mCancelImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.submissionCancelled();
            }
        });

        mConfirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.submissionConfirmed();
            }
        });
    }
}
