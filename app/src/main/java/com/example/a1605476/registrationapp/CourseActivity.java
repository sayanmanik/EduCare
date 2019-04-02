package com.example.a1605476.registrationapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;


public class CourseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    RecyclerView recyclerView;
    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        recyclerView= (RecyclerView) findViewById(R.id.recycler_course);
        drawer=(DrawerLayout)findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(
                this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);


        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        String name[]=new String[2];
        int image[]=new int[2];

        /*for(int i=0;i<name.length;i++)
        {
            name[i]= CourseItem.course[i].getName();
        }*/
        name[0]="C";
        name[1]="C++";

        image[0]=R.drawable.c;
        image[1]=R.drawable.c_plus_plus;

        /*for(int i=0;i<image.length;i++)
        {
            image[i]=CourseItem.course[i].getImage();
        }*/

        com.example.a1605476.registrationapp.Adapter.CourseAdapter adapter=new com.example.a1605476.registrationapp.Adapter.CourseAdapter(name,image);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter.setListener(new com.example.a1605476.registrationapp.Adapter.CourseAdapter.Listener() {
            @Override
            public void onClick(int position)
            {
                if(position==0)
                {
                    Intent intent=new Intent(CourseActivity.this,LastActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Intent intent=new Intent(CourseActivity.this,Other.class);
                    startActivity(intent);
                }
            }
        });
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
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.topics) {
            // Handle the camera action
        } else if (id == R.id.friends) {

        } else if (id == R.id.messages) {

        } else if (id == R.id.achievements) {

        } else if (id == R.id.settings) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
