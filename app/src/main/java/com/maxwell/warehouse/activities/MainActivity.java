package com.maxwell.warehouse.activities;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.maxwell.warehouse.R;
import com.maxwell.warehouse.fragments.HomeListFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    RelativeLayout containerFragments;
    ImageView ivFenix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        containerFragments = (RelativeLayout) findViewById(R.id.containerFragments);
        ivFenix = (ImageView) findViewById(R.id.ivFenix);
        containerFragments.setId(R.id.containerFragments);

        /*fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        ivFenix.setVisibility(View.GONE);
        FragmentManager fm = getSupportFragmentManager();
        HomeListFragment socialFragment = new HomeListFragment();
        Bundle genericBundle = new Bundle();
        switch (id){
            case R.id.nav_anim:
                genericBundle.putString(HomeListFragment.TYPE, HomeListFragment.ANIMATIONS);
                break;
            case R.id.nav_dev:
                genericBundle.putString(HomeListFragment.TYPE, HomeListFragment.DEVS);
                break;
            case R.id.nav_location:
                genericBundle.putString(HomeListFragment.TYPE, HomeListFragment.LOC);
                break;
            case R.id.nav_multimedia:
                genericBundle.putString(HomeListFragment.TYPE, HomeListFragment.MULTIMEDIA);
                break;
            case R.id.nav_social:
                genericBundle.putString(HomeListFragment.TYPE, HomeListFragment.SOCIAL);
                break;
            case R.id.nav_storage:
                genericBundle.putString(HomeListFragment.TYPE, HomeListFragment.STORAGE);
                break;
            case R.id.nav_ui:
                genericBundle.putString(HomeListFragment.TYPE, HomeListFragment.UI);
                break;
        }

        socialFragment.setArguments(genericBundle);

        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(containerFragments.getId(), socialFragment);
        ft.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
