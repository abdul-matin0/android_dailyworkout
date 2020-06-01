package com.matin.exerciseapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.matin.exerciseapp.HomeAdapter.FeaturedAdapter;
import com.matin.exerciseapp.HomeAdapter.FeaturedHelperClass;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class ExerciseActivity extends AppCompatActivity {

    TextView dayTextView, greetingTextView, timeTextView;
    RecyclerView featuredRecycler;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        dayTextView = (TextView) findViewById(R.id.ellianaTextView);
        greetingTextView = (TextView) findViewById(R.id.dayTextView);
        timeTextView = (TextView) findViewById(R.id.timeTextView);

        String header = getIntent().getStringExtra("title");
        String desc = getIntent().getStringExtra("desc");

        //get system date
        Calendar calendar = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("EEE, MMM d, yyyy");
        String date = dateFormat.format(calendar.getTime());

        timeTextView.setText(date);


//        getSupportActionBar().setTitle(header);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //back to homeactivity but its actually the featuredadapter class

        dayTextView.setText(header);
        greetingTextView.setText(desc);


        featuredRecycler = (RecyclerView) findViewById(R.id.featured_recycler);

        featuredRecycler();

    }

    private void featuredRecycler() {

        featuredRecycler.setHasFixedSize(true); //load views only visible to users #recycler contains lots of card views, some are on the screen and some are off the screen
        featuredRecycler.setLayoutManager(new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false));

        //pass array to design adapter
        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();

        featuredLocations.add(new FeaturedHelperClass(R.drawable.meditation, "Meditation", ""));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.exerciseillustration, "Stretch out", ""));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.yoga, "Yoga", ""));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.meditation, "Meditation", ""));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.exerciseillustration, "Stretch out", ""));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.yoga, "Yoga", ""));

        adapter = new FeaturedAdapter(featuredLocations, R.layout.featured_card_grid);
        featuredRecycler.setAdapter(adapter);
    }
}
