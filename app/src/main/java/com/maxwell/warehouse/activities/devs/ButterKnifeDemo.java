package com.maxwell.warehouse.activities.devs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


import com.maxwell.warehouse.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Maxwell on 16/09/2015.
 */
public class ButterKnifeDemo extends AppCompatActivity {
    @Bind(R.id.username) TextView username;
    @Bind(R.id.name) TextView name;
    @Bind(R.id.location) TextView location;
    @Bind(R.id.blog) TextView blog;
    @Bind(R.id.email) TextView email;
    @Bind(R.id.repos) TextView repos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.github_layout);

        ButterKnife.bind(this);

        username.setText("Maxwell");
        name.setText("Maxi");
        location.setText("Pais: Argentina");
        blog.setText("Blog: no tengo");
        email.setText("Email: pepe@gmail.com");
        repos.setText("Repositorios: 5");
    }
}
