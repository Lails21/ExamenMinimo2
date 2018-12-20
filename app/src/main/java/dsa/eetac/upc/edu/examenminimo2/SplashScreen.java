package dsa.eetac.upc.edu.examenminimo2;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;

public class SplashScreen extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
            }
        }, 2000);
        */
        super.onCreate(savedInstanceState);
        final SharedPreferences sharedPref =
                PreferenceManager.getDefaultSharedPreferences(this);
        boolean registered = sharedPref.getBoolean("registered", false);
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
