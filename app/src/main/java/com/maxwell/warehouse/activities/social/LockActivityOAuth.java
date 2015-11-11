package com.maxwell.warehouse.activities.social;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.auth0.core.Token;
import com.auth0.core.UserProfile;
import com.auth0.lock.Lock;
import com.auth0.lock.LockActivity;
import com.maxwell.warehouse.R;

/**
 * Created by Maximiliano on 11/11/15.
 */
public class LockActivityOAuth extends AppCompatActivity {
    LocalBroadcastManager broadcastManager;
    TextView simpleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_layout);

        simpleText = (TextView) findViewById(R.id.simpleText);

        Intent lockIntent = new Intent(this, LockActivity.class);
        startActivity(lockIntent);

        broadcastManager = LocalBroadcastManager.getInstance(this);
        broadcastManager.registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                UserProfile profile = intent.getParcelableExtra(Lock.AUTHENTICATION_ACTION_PROFILE_PARAMETER);
                Token token = intent.getParcelableExtra(Lock.AUTHENTICATION_ACTION_TOKEN_PARAMETER);
                //Your code to handle login information.

                simpleText.setText(profile.getName());
            }
        }, new IntentFilter(Lock.AUTHENTICATION_ACTION));
    }
}
