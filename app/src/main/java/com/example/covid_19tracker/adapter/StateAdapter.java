package com.example.covid_19tracker.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid_19tracker.R;
import com.example.covid_19tracker.model.StateModel;

import java.util.ArrayList;

public class StateAdapter extends RecyclerView.Adapter<StateAdapter.ViewHolder> {

    public StateAdapter(ArrayList<StateModel> arrayList) {

        this.arrayList = arrayList;
    }


    private ArrayList<StateModel>arrayList;




    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.statecase,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
StateModel stateModel=arrayList.get(position);
holder.StateName.setText(stateModel.getStateName());
        holder.StateCase.setText(stateModel.getStateCase());
    }

    @Override
    public int getItemCount() {

        return arrayList!=null?arrayList.size():0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView StateName, StateCase;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);


       StateCase= itemView.findViewById(R.id.cccases);
       StateName=itemView.findViewById(R.id.sname);
        }
    }
}

