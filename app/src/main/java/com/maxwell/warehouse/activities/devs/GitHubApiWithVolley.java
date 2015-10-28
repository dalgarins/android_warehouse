package com.maxwell.warehouse.activities.devs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.maxwell.warehouse.R;
import com.maxwell.warehouse.helpers.VolleyHelper;
import com.maxwell.warehouse.interfaces.GitHubService;
import com.maxwell.warehouse.interfaces.OnGitHubResult;
import com.maxwell.warehouse.loaders.GitHubLoader;
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
public class GitHubApiWithVolley extends AppCompatActivity implements OnGitHubResult{
    ImageView avatar;
    TextView username, name, location, blog, email, repos, gists, followers, following;
    private GitHubLoader loader;

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

        loader = new GitHubLoader(this,"maxwellnewage");

        VolleyHelper.getInstance(this).addToRequestQueue(loader.getRequest());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        VolleyHelper.getInstance(this).getRequestQueue().cancelAll(loader.TAG);
    }

    @Override
    public void onSuccess(GitHubUser res) {
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
    public void onNetworkError() {

    }

    @Override
    public void onError() {

    }
}
