package com.example.covid_19tracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import com.example.covid_19tracker.Fragment.CountryiesFrag;
import com.example.covid_19tracker.Fragment.HomeFrag;
import com.example.covid_19tracker.Fragment.IndiaFrag;
import com.example.covid_19tracker.Fragment.SymptomsFrag;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {
TextView t1, t2, t3;
Toolbar toolbar;
BottomNavigationView bottomNavigationView;

CollapsingToolbarLayout collapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitymain2);

      ViewInit();
toolbarSetup();
bottomSetup();
  }
    private void bottomSetup() {
       bottomNavigationView .setItemIconTintList(null);
        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.Home:
                     Toast.makeText(getApplicationContext(),"Home Fragment",Toast.LENGTH_SHORT).show();
                        Fragment homeFrag= new HomeFrag();
                        FragmentManager fragmentManager= getSupportFragmentManager();

                        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                      fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                        fragmentTransaction.replace(R.id.container,homeFrag).commit();
                        break;

                    case  R.id.India:
                        Toast.makeText(getApplicationContext(),"India Fragment",Toast.LENGTH_SHORT).show();
                        Fragment indiaFrag= new IndiaFrag();
                        FragmentManager fragmentManager1= getSupportFragmentManager();

                        FragmentTransaction fragmentTransaction1=fragmentManager1.beginTransaction();
                        fragmentTransaction1.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                        fragmentTransaction1.replace(R.id.container,indiaFrag).commit();
                        break;

                    case  R.id.AllCountries:
                        Toast.makeText(getApplicationContext(),"AllCountries Fragment",Toast.LENGTH_SHORT).show();
                        Fragment country= new CountryiesFrag();
                        FragmentManager fragmentManager2= getSupportFragmentManager();

                        FragmentTransaction fragmentTransaction2=fragmentManager2.beginTransaction();
                        fragmentTransaction2.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                        fragmentTransaction2.replace(R.id.container,country).commit();
                        break;

                    case  R.id.Symptoms:
                        Toast.makeText(getApplicationContext(),"Symptoms Fragment",Toast.LENGTH_SHORT).show();
                        Fragment symptoms= new SymptomsFrag();
                        FragmentManager fragmentManager3= getSupportFragmentManager();

                        FragmentTransaction fragmentTransaction3=fragmentManager3.beginTransaction();
                        fragmentTransaction3.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                        fragmentTransaction3.replace(R.id.container,symptoms).commit();
                        break;
                }}
        });
    }

    private void toolbarSetup() {
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Menu button Clicked",Toast.LENGTH_SHORT).show();
            }
        });
    }



    private void ViewInit() {

        t2=findViewById(R.id.t2);
        t3=findViewById(R.id.t3);
        toolbar= findViewById(R.id.toolbar);
      bottomNavigationView=findViewById(R.id.menubottom);
        collapsingToolbarLayout=findViewById(R.id.colLayout);

    }

    @Override
    protected void onStart() {
        super.onStart();

        Fragment homeFrag= new HomeFrag();
        FragmentManager fragmentManager= getSupportFragmentManager();

        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.replace(R.id.container,homeFrag).commit();
    }
}
