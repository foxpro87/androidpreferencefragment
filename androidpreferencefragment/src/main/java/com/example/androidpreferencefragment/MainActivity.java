package com.example.androidpreferencefragment;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    Button buttonSetPreference;
    TextView settingCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSetPreference = (Button)findViewById(R.id.setpreference);
        settingCheckBox = (TextView)findViewById(R.id.setting_checkbox);

        buttonSetPreference.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                Intent intentSetPref = new Intent(getApplicationContext(), PrefActivity.class);
                startActivityForResult(intentSetPref, 0);
            }});
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        Boolean prefCheckBox = sharedPreferences.getBoolean("PREF_CHECKBOX", false);
        settingCheckBox.setText("CHECKBOX preference = " + prefCheckBox.toString());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
