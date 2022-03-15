package com.example.covid_19tracker.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.covid_19tracker.R;
import com.example.covid_19tracker.adapter.CountryAdapter;
import com.example.covid_19tracker.adapter.StateAdapter;
import com.example.covid_19tracker.model.CountryModel;
import com.example.covid_19tracker.model.StateModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class CountryiesFrag extends Fragment {
    private ArrayList<CountryModel>arrayList;
    RecyclerView recyclerView;
    View view;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_countryies, container, false);
        getdata();
        init();
        return view;
    }



    private void init(){
        recyclerView=view.findViewById(R.id.rrecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        CountryAdapter countryAdapter= new CountryAdapter(arrayList);
        recyclerView.setAdapter(countryAdapter);
    }

    private void getdata() {
        String url="https://coronavirus-19-api.herokuapp.com/countries";

        RequestQueue requestQueue= Volley.newRequestQueue(getActivity());

        arrayList=new ArrayList<>();
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    for (int i = 0; i < response.length(); i++) {

                        JSONObject data = response.getJSONObject(i);
                        String country = data.getString("country");
                        String cases = data.getString("cases");

                        CountryModel countryModel = new CountryModel(country, cases);
                        arrayList.add(countryModel);
                    }init();
                }catch (JSONException e) {
                        e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
               // Log.i("tag",String.valueOf(error));
                Toast.makeText(getActivity(),""+error,Toast.LENGTH_LONG).show();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);




    }


}

