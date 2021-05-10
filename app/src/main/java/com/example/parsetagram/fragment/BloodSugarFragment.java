package com.example.parsetagram.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.parsetagram.MainActivity;
import com.example.parsetagram.BG;
import com.example.parsetagram.R;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.io.File;
import java.util.List;



public class BloodSugarFragment extends Fragment {

    public static final String TAG = "BloodSugar";
    private EditText etBloodSugar;
    private Button btBreakfast;
    private Button btLunch;
    private Button btDinner;
    private Button btSnack;



    public BloodSugarFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blood_sugar, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btBreakfast = view.findViewById(R.id.btBreakfast);
        btLunch = view.findViewById(R.id.btLunch);
        btDinner = view.findViewById(R.id.btDinner);
        btSnack = view.findViewById(R.id.btSnack);
        etBloodSugar= view.findViewById(R.id.etBloodSugar);


        btBreakfast.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                int bloodSugar = Integer.parseInt(etBloodSugar.getText().toString());
                if(bloodSugar == 0){
                    Toast.makeText(getContext(), "Please enter a blood sugar value", Toast.LENGTH_SHORT).show();
                    return;
                }
                ParseUser currentUser = ParseUser.getCurrentUser();
                saveBG(bloodSugar, currentUser, 1);
            }
        });
        btLunch.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                int bloodSugar = Integer.parseInt(etBloodSugar.getText().toString());
                if(bloodSugar == 0){
                    Toast.makeText(getContext(), "Please enter a blood sugar value", Toast.LENGTH_SHORT).show();
                    return;
                }
                ParseUser currentUser = ParseUser.getCurrentUser();
                saveBG(bloodSugar, currentUser, 2);
            }
        });

        btDinner.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                int bloodSugar = Integer.parseInt(etBloodSugar.getText().toString());
                if(bloodSugar == 0){
                    Toast.makeText(getContext(), "Please enter a blood sugar value", Toast.LENGTH_SHORT).show();
                    return;
                }
                ParseUser currentUser = ParseUser.getCurrentUser();
                saveBG(bloodSugar, currentUser, 3);
            }
        });

        btSnack.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                int bloodSugar = Integer.parseInt(etBloodSugar.getText().toString());
                if(bloodSugar == 0){
                    Toast.makeText(getContext(), "Please enter a blood sugar value", Toast.LENGTH_SHORT).show();
                    return;
                }
                ParseUser currentUser = ParseUser.getCurrentUser();
                saveBG(bloodSugar, currentUser, 4);
            }
        });
    }


    private void saveBG(int bloodSugar, ParseUser currentUser, int meal) {
        int bloodLevel=bloodSugar;
        int mealTime=meal;

        BG bg = new BG();
        bg.setMeal(mealTime);
        bg.setValue(bloodLevel);
        bg.setUser(currentUser);
        bg.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e!= null){
                    Log.e(TAG, "error with getting posts", e);
                    Toast.makeText(getContext(), "Error while saving!", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(getContext(), "BG "+ bloodLevel + " at meal # "+ mealTime, Toast.LENGTH_SHORT).show();
                etBloodSugar.setText("");
            }
        });
    }


}
