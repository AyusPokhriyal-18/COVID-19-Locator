package com.example.covid_19tracker.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.covid_19tracker.R;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFrag extends Fragment {

 TextView totalCase,totalDeath,totalRecov;
 View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
    view= inflater.inflate(R.layout.fragment_home, container, false);

   viewInit();
    getDataAPI();
    return view;
    }

    private void getDataAPI() {
        RequestQueue requestQueue= Volley.newRequestQueue(getActivity());

        String url="https://disease.sh/v3/covid-19/all ";
        StringRequest stringRequest= new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                 JSONObject jsonObject=new JSONObject(response);
                    totalCase.setText(jsonObject.getString("cases"));
                    totalDeath.setText(jsonObject.getString("deaths"));
                    totalRecov.setText( jsonObject.getString("recovered"));

                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getActivity(),""+e,Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("tag",String.valueOf(error));
                Toast.makeText(getActivity(),""+error,Toast.LENGTH_LONG).show();
            }

    });
   requestQueue.add(stringRequest);
    }

    private void viewInit() {
        totalCase=view.findViewById(R.id.cases);
        totalDeath=view.findViewById(R.id.deaths);
        totalRecov=view.findViewById(R.id.recover);
    }
}
