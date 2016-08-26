package com.example.allfree.conotan_bootstrap;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import com.kii.cloud.storage.KiiUser;
import com.kii.cloud.storage.callback.KiiUserCallBack;
import com.kii.cloud.storage.utils.Log;

public class MainActivity extends AppCompatActivity {

    private BroadcastReceiver mRegistrationBroadcastReceiver;
    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BootstrapButton parent_button = (BootstrapButton) findViewById(R.id.parent);
        parent_button.setTextSize(70);
        parent_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SendActivity.class);
                startActivity(intent);
            }
        });
        BootstrapButton child_button = (BootstrapButton) findViewById(R.id.child);
        child_button.setTextSize(70);
        child_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HelpDetailActivity.class);
                startActivity(intent);
            }
        });

        mRegistrationBroadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String errorMessage = intent.getStringExtra(RegistrationIntentService.PARAM_ERROR_MESSAGE);
                Log.e("GCMTest", "Registration completed:" + errorMessage);
                if (errorMessage != null) {
                    Toast.makeText(MainActivity.this, "Error push registration:" + errorMessage, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Succeeded push registration", Toast.LENGTH_LONG).show();
                }
            }
        };

        if (!checkPlayServices()) {
            Toast.makeText(MainActivity.this, "This application needs Google Play services", Toast.LENGTH_LONG).show();
            return;
        }

        String username = "user1";
        String password = "123ABC";
        KiiUser.logIn(new KiiUserCallBack() {
            @Override
            public void onLoginCompleted(int token, KiiUser user, Exception exception) {
                if (exception != null) {
                    Toast.makeText(MainActivity.this, "Error login user:" + exception.getMessage(), Toast.LENGTH_LONG).show();
                    return;
                }
                Toast.makeText(MainActivity.this, "Succeeded to login", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, RegistrationIntentService.class);
                startService(intent);
            }
        }, username, password);
    }


    private boolean checkPlayServices () {
        GoogleApiAvailability apiAvailability = GoogleApiAvailability.getInstance();
        int resultCode = apiAvailability.isGooglePlayServicesAvailable(this);
        if (resultCode != ConnectionResult.SUCCESS) {
            if (apiAvailability.isUserResolvableError(resultCode)) {
                apiAvailability.getErrorDialog(this, resultCode, PLAY_SERVICES_RESOLUTION_REQUEST).show();
            } else {
                Log.i("PushTest", "This device is not supported.");
                finish();
            }
            return false;
        }
        return true;
    }

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.

    @Override
    protected void onResume() {
        super.onResume();
        LocalBroadcastManager.getInstance(this).registerReceiver(mRegistrationBroadcastReceiver,
                new IntentFilter(RegistrationIntentService.INTENT_PUSH_REGISTRATION_COMPLETED));
    }

    @Override
    protected void onPause() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mRegistrationBroadcastReceiver);
        super.onPause();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
