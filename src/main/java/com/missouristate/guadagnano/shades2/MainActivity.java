package com.missouristate.guadagnano.shades2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity implements MyListFragment.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onColorItemsSelected(String link) {
        InformationFragment fragment2 = (InformationFragment) getFragmentManager().findFragmentById(R.id.fragment2);

        if (fragment2 !=null && fragment2.isInLayout()) {
            fragment2.setText(link);
        }
        else {
            Intent intent = new Intent (this, InformationActivity.class);
            intent.putExtra("Information", link);
            startActivity (intent);
        }
    }
}
