package com.example.covid_19tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.covid_19tracker.Fragment.HomeFrag;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashactivity);

   new Handler().postDelayed(new Runnable() {
       @Override
       public void run() {
           Intent intent=new Intent(SplashActivity.this, MainActivity.class);
           overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
      startActivity(intent);
      finish();
       }
   }, 2000);
    }


}

