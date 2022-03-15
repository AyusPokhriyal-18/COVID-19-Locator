package com.example.covid_19tracker.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid_19tracker.R;
import com.example.covid_19tracker.model.CountryModel;
import com.example.covid_19tracker.model.StateModel;

import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {

    public CountryAdapter(ArrayList<CountryModel> arrayList) {

        this.arrayList = arrayList;
    }


    private ArrayList<CountryModel>arrayList;




    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.countrycase,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CountryModel countryModel=arrayList.get(position);
        holder.countryName.setText(countryModel.getCountryName());
        holder.countryCase.setText(countryModel.getCountryCase());
    }

    @Override
    public int getItemCount() {

        return arrayList!=null?arrayList.size():0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView countryCase, countryName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            countryCase= itemView.findViewById(R.id.concases);
            countryName=itemView.findViewById(R.id.cname);
        }
    }
}
