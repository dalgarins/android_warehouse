package com.maxwell.warehouse.activities.user_interface;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.maxwell.warehouse.R;
import com.maxwell.warehouse.providers.UserProvider;

/**
 * Created by root on 14/10/15.
 */
public class UserList extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacts_layout);
    }

    public void onClickAddName(View view) {
        ContentValues values = new ContentValues();
        values.put(UserProvider.PROVIDER_NAME, ((EditText) findViewById(R.id.txtName))
                .getText().toString());
        Uri uri = getContentResolver().insert(UserProvider.CONTENT_URI, values);
        Toast.makeText(getBaseContext(), "New record inserted", Toast.LENGTH_LONG)
                .show();
    }
}
