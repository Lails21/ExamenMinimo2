package dsa.eetac.upc.edu.examenminimo2;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.Log;

public class SplashScreen extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final SharedPreferences sharedPref =
                PreferenceManager.getDefaultSharedPreferences(this);
        boolean registered = sharedPref.getBoolean("registered", false);

        Log.i("GITHUB",  "registered"+registered);
        Class dest;
        if (!registered) {
            dest= LoginActivity.class;
        } else{
            dest = MainActivity.class;
        }
        Intent intent = new Intent(this, dest);
        startActivity(intent);
        finish();
    }

}
