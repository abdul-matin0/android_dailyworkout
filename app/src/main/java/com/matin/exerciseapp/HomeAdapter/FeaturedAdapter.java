package com.matin.exerciseapp.HomeAdapter;

import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.matin.exerciseapp.ExerciseActivity;
import com.matin.exerciseapp.R;

import java.nio.DoubleBuffer;
import java.util.ArrayList;

public class FeaturedAdapter extends RecyclerView.Adapter <FeaturedAdapter.FeaturedViewHolder>{

 //adapter holds the value and put the values to the design, gets design and gets values and works as a bridge between design and values
    //values
    ArrayList<FeaturedHelperClass> featuredLocations;
    FeaturedHelperClass featuredHelperClass;
    int card;

    //gets data
    public FeaturedAdapter(ArrayList<FeaturedHelperClass> featuredLocations, int card) {
        this.featuredLocations = featuredLocations;
        this.card = card;
    }

    @NonNull
    @Override
    public FeaturedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(card, parent, false); //pass view to FeaturedViewHolder class
        FeaturedViewHolder featuredViewHolder = new FeaturedViewHolder(view);

        return featuredViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedViewHolder holder, int position) {

        featuredHelperClass= featuredLocations.get(position);
        holder.image.setImageResource(featuredHelperClass.getImage());
        holder.title.setText(featuredHelperClass.getTitle());
        holder.description.setText(featuredHelperClass.getDescription());

    }

    @Override
    public int getItemCount() {
        return featuredLocations.size();
    }


    //gets design #holds view
    public class FeaturedViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title;
        Button description;

        public FeaturedViewHolder(@NonNull View itemView) {
            super(itemView);

            //for design hooks are necessary
            //Hooks
            image = itemView.findViewById(R.id.featured_image); //layout file(featured_card_design)would be received by item view when FeaturedHolder class is called
            description = itemView.findViewById(R.id.featured_desc);
            title = itemView.findViewById(R.id.featured_title);


            description.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), ExerciseActivity.class);
                    featuredHelperClass = featuredLocations.get(getAdapterPosition());

                    intent.putExtra("title", featuredHelperClass.getTitle());
                    intent.putExtra("desc", featuredHelperClass.getDescription());

                    v.getContext().startActivity(intent);
                }
            });
        }
    }
}