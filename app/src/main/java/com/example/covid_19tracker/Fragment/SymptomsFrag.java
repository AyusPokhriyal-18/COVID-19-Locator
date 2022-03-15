package com.example.covid_19tracker.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.covid_19tracker.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SymptomsFrag extends Fragment {

    public SymptomsFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_symptoms2, container, false);
    }
}
