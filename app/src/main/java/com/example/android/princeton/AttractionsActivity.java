package com.example.android.princeton;

import android.app.Activity;
import android.os.Bundle;

public class AttractionsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new AttractionsFragment())
                .commit();
    }
}
