package com.missouristate.guadagnano.shades2;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.TextView;

public class InformationActivity extends Activity{
    public static final String EXTRA_URL = "url";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish();
            return;
        }
        setContentView(R.layout.information_fragment);

        getActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String informationValue = intent.getStringExtra("Information");
        TextView info = findViewById(R.id.textView1);
        info.setText(informationValue);
    }
}
