package com.maxwell.warehouse.activities.user_interface;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.maxwell.warehouse.R;
import com.maxwell.warehouse.content_providers.UserProvider;

/**
 * Created by root on 14/10/15.
 */
public class ContactsList extends AppCompatActivity{

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
