package com.zkcnt.cardviewexpandable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static String TAG = "MAIN_ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onFragmentChanged("CARD_VIEW_FRAGMENT");
    }

    public void onFragmentChanged(String fragmentName) {
        Log.d(TAG, "onFragmentChanged: (Change to page)" + fragmentName);
        if("CARD_VIEW_FRAGMENT".equalsIgnoreCase(fragmentName)) {
            getSupportFragmentManager().beginTransaction().replace(R.id.main_view, CardViewFragment.newInstance()).commit();
        }
    }
}