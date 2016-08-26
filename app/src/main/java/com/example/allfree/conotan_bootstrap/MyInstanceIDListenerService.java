package com.example.allfree.conotan_bootstrap;

import android.content.Intent;

import com.google.android.gms.iid.InstanceIDListenerService;

/**
 * Created by Owner on 2016/08/26.
 */
public class MyInstanceIDListenerService extends InstanceIDListenerService {
    @Override
    public void onTokenRefresh() {
        Intent intent = new Intent(this, RegistrationIntentService.class);
        startService(intent);
    }
}
