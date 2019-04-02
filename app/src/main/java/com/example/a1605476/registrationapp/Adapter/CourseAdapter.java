package com.example.a1605476.registrationapp.Adapter;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import com.example.a1605476.registrationapp.R;
import com.makeramen.roundedimageview.RoundedTransformationBuilder;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1605476 on 27-Mar-18.
 */

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder>
{    int a;
    String[] name;
   int[] image;

    Listener listener;

    public static interface Listener
    {
        public void onClick(int position);
    }

    public void setListener(Listener listener)
    {
        this.listener=listener;
    }

    public CourseAdapter(String[] name,int[] image)
    {
        this.name=name;
        this.image=image;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        CardView view= (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_course,parent,false);
        return new CourseAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        CardView cardView=holder.mView;

        ImageView imageView=cardView.findViewById(R.id.image);
        TextView textView=cardView.findViewById(R.id.detail);

        textView.setText(name[position]);
        Drawable drawable=cardView.getResources().getDrawable(image[position]);
        imageView.setImageDrawable(drawable);

        cardView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v)
            {
                listener.onClick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return name.length;
    }


    public class ViewHolder extends RecyclerView.ViewHolder
    {
        CardView mView;
        ImageView courseImage;
        TextView detailText;

        public ViewHolder(CardView v) {
            super(v);
            mView=v;
            a=getAdapterPosition();

            //courseImage=v.findViewById(R.id.image);
            //detailText=v.findViewById(R.id.detail);

        }
    }

    public void displayPhoto(ImageView imageView,String image)
    {
        Transformation transformation=
                 new RoundedTransformationBuilder().oval(false).cornerRadius(30).build();
        Picasso.with(imageView.getContext()).load(Uri.parse(image)).placeholder(R.drawable.c)
                .transform(transformation).into(imageView);
    }
}
