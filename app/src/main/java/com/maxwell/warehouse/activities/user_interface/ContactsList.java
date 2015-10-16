package com.maxwell.warehouse.activities.user_interface;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by root on 14/10/15.
 */
public class ContactsList extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ContentResolver cr = getContentResolver();
        Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI,null,null,null,null);

        if(cur.getCount() > 0){
            while (cur.moveToNext()){
                String id = cur.getString(cur.getColumnIndex(ContactsContract.Contacts._ID));
                String name = cur.getString(cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                String hasPhoneNumber = cur.getString(cur.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER));

                if(Integer.parseInt(hasPhoneNumber) > 0){
                    //Cursor pCur = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI)
                }
            }
        }
    }
}
