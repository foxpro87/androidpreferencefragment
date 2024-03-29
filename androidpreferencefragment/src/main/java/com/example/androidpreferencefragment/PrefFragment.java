package com.example.androidpreferencefragment;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.widget.Toast;

/**
 * Created by sbwoo on 13. 6. 18.
 */
public class PrefFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
        // Get the custom preference
        Preference customPref = (Preference) findPreference("customPref");
        customPref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {

            public boolean onPreferenceClick(Preference preference) {
                Toast.makeText(getActivity(), "The custom preference has been clicked", Toast.LENGTH_LONG).show();

                SharedPreferences customSharedPreference = getActivity().getSharedPreferences("myCustomSharedPrefs", Activity.MODE_PRIVATE);
                SharedPreferences.Editor editor = customSharedPreference.edit();
                editor.putString("myCustomPref", "The preference has been clicked");
                editor.commit();
                return true;
            }

        });
    }

}