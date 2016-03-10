package tarahang.activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

import tarahang.fragments.FriendsFragment;
import tarahang.fragments.HangsFragment;
import tarahang.fragments.ProfileFragment;

public class MainApp extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    final static String SP_KEY_USERNAME = "username";

    TextView usernameDrawer;
    NavigationView navHeaderMainApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_app);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        navHeaderMainApp = (NavigationView) findViewById(R.id.nav_view);
        usernameDrawer = (TextView) navHeaderMainApp.getHeaderView(0).findViewById(R.id.usernameDrawer);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        String username = sp.getString(SP_KEY_USERNAME, null);

        if(username == null){
            Intent loginIntent = new Intent(getBaseContext(), Login.class);
            startActivity(loginIntent);
        }else{
            // TODO: set user info here
            //greetNameTV.setText("Greetings " + username + "!");
            usernameDrawer.setText(username);
        }
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_profile) {
            Fragment fragment = new ProfileFragment();
            Bundle args = new Bundle();
//            args.putInt(PlanetFragment.ARG_PLANET_NUMBER, position);
            fragment.setArguments(args);

            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
        } else if (id == R.id.nav_friends) {
            Fragment fragment = new FriendsFragment();
            Bundle args = new Bundle();
//            args.putInt(PlanetFragment.ARG_PLANET_NUMBER, position);
            fragment.setArguments(args);

            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
        } else if (id == R.id.nav_hangs) {
            Fragment fragment = new HangsFragment();
            Bundle args = new Bundle();
//            args.putInt(PlanetFragment.ARG_PLANET_NUMBER, position);
            fragment.setArguments(args);

            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
        } else if (id == R.id.nav_logout) {
            SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
            SharedPreferences.Editor spEditor = sp.edit();
            spEditor.clear();
            spEditor.commit();
            Intent loginIntent = new Intent(getBaseContext(), Login.class);
            startActivity(loginIntent);
            return true;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
