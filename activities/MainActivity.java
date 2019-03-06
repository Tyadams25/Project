package com.example.cpshome.navagationbar.activities;

import android.os.Bundle;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout; // This imports the widget for the layout of the navagation drawer
import android.support.v7.app.ActionBarDrawerToggle; // Imports the ability to drawer out into the page via the menu button
import android.support.v7.app.AppCompatActivity; // Imports base class to use a support library for actoin bar features.
import android.support.v7.widget.Toolbar; // Imports generalization of actions bar when creating layout fo app
import android.view.MenuItem;

import com.example.cpshome.navagationbar.R;


public class MainActivity extends AppCompatActivity {
    // Creates new activity(Main activity of app)


    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            // Creates layout of xml file
            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            // Creates toolbar for the drawer
            DrawerLayout drawerLayout = findViewById(R.id.drawe);
            // Creates layout of drawer menu
            ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                    R.string.drawer_open, R.string.drawer_close);
            drawerLayout.addDrawerListener(actionBarDrawerToggle);
            actionBarDrawerToggle.syncState();

            // Allows for the drawer to open an close on the click of the menu icon and the action for it to come out from the left when pressed.

        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
}