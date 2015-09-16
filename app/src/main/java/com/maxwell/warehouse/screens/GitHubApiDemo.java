package com.maxwell.warehouse.screens;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.maxwell.warehouse.R;
import com.maxwell.warehouse.interfaces.GitHubService;
import com.maxwell.warehouse.models.GitHubUser;
import com.maxwell.warehouse.utils.Constants;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by Maximiliano on 15/09/15.
 */
public class GitHubApiDemo extends Activity {
    ImageView avatar;
    TextView username, name, location, blog, email, repos, gists, followers, following;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.github_layout);

        avatar = (ImageView) findViewById(R.id.avatar);
        username = (TextView) findViewById(R.id.username);
        name = (TextView) findViewById(R.id.name);
        location = (TextView) findViewById(R.id.location);
        blog = (TextView) findViewById(R.id.blog);
        email = (TextView) findViewById(R.id.email);
        repos = (TextView) findViewById(R.id.repos);
        gists = (TextView) findViewById(R.id.gists);
        followers = (TextView) findViewById(R.id.followers);
        following = (TextView) findViewById(R.id.following);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.API_GITHUB)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GitHubService gitHubService = retrofit.create(GitHubService.class);
        Call<GitHubUser> call = gitHubService.getUser("maxwellnewage");


        call.enqueue(new Callback<GitHubUser>() {
            @Override
            public void onResponse(Response<GitHubUser> response) {
                // Get result Repo from response.body()
                GitHubUser res = response.body();

                Glide.with(GitHubApiDemo.this).load(res.getAvatar_url()).into(avatar);

                username.setText(res.getLogin());
                name.setText(res.getName());
                location.setText("Pais: " + res.getLocation());
                blog.setText("Blog: " + res.getBlog());
                email.setText("E-mail: " + res.getEmail());
                repos.setText("Repositorios: " + res.getPublic_repos());
                gists.setText("Gists: " + res.getPublic_gists());
                followers.setText("Seguidores: " + res.getFollowers());
                following.setText("Siguiendo: " + res.getFollowing());
            }

            @Override
            public void onFailure(Throwable t) {
                Log.i("debug_log", "falla");
            }
        });
    }
}
