package com.matin.exerciseapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.matin.exerciseapp.HomeAdapter.FeaturedAdapter;
import com.matin.exerciseapp.HomeAdapter.FeaturedHelperClass;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {


    RecyclerView featuredRecycler;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

//        getSupportActionBar().hide();

        //Hooks
        featuredRecycler = (RecyclerView) findViewById(R.id.featured_recycler);

        featuredRecycler();
    }

    private void featuredRecycler() {

        featuredRecycler.setHasFixedSize(true); //load views only visible to users #recycler contains lots of card views, some are on the screen and some are off the screen
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        //pass array to design adapter
        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();

        featuredLocations.add(new FeaturedHelperClass(R.drawable.meditation, "Meditation", "Day 1"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.exerciseillustration, "Stretch out", "Day 2"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.yoga, "Diet Double", "Day 3"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.meditation, "Meditation", "Day 4"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.exerciseillustration, "Stretch out", "Day 5"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.yoga, "Diet Double", "Day 6"));

        adapter = new FeaturedAdapter(featuredLocations, R.layout.featured_card_design);
        featuredRecycler.setAdapter(adapter);
    }
}
