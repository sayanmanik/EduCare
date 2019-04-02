package com.example.a1605476.registrationapp.Adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a1605476.registrationapp.R;

/**
 * Created by 1605476 on 29-Mar-18.
 */

public class CDescriptionsAdapter extends RecyclerView.Adapter<CDescriptionsAdapter.ViewHolder> {

    Listener listener;
    String name[];
    String id[];


    public CDescriptionsAdapter(String name[],String id[])
    {
        this.name=name;
        this.id=id;
    }


    public static interface Listener
    {
        public void onClick(int position);
    }

    public void setListener(Listener listener)
    {
        this.listener=listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View recyclerView=
                 LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_c,null,false);

        return new ViewHolder(recyclerView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        View view=holder.recyclerView;

        TextView idView=view.findViewById(R.id.id);
        TextView nameView=view.findViewById(R.id.name);

        idView.setText(id[position]);
        nameView.setText(name[position]);

    }



    @Override
    public int getItemCount() {
        return name.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {
    View recyclerView;
    TextView id,name;
        public ViewHolder(View itemView) {
            super(itemView);

            recyclerView=itemView;

        }
    }
}