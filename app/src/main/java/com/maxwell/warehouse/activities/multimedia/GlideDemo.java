package com.maxwell.warehouse.activities.multimedia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.maxwell.warehouse.R;

/**
 * Created by Maximiliano on 15/09/15.
 */
public class GlideDemo extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.glide_image);

        ImageView glideImage = (ImageView) findViewById(R.id.glideImage);

        Glide.with(this).load("http://goo.gl/gEgYUd").into(glideImage);
    }
}
