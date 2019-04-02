package com.example.a1605476.registrationapp.FragmentDirectory;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a1605476.registrationapp.Adapter.CDescriptionsAdapter;
import com.example.a1605476.registrationapp.Description.C_Description;
import com.example.a1605476.registrationapp.Description.C_Plus_Plus_Description;
import com.example.a1605476.registrationapp.LastActivity;
import com.example.a1605476.registrationapp.R;

import static com.example.a1605476.registrationapp.Description.C_Description.c_description;
import static com.example.a1605476.registrationapp.Description.C_Plus_Plus_Description.c_plus_plus_description;


/**
 * Created by 1605476 on 29-Mar-18.
 */

public class CFragment extends Fragment
{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)
    {

        RecyclerView recyclerView=(RecyclerView) inflater.inflate(R.layout.fragment_cfragment,container,false);

        String name[]=new String[c_description.length];
        String id[]=new String[c_description.length];

        id[0]="Introduction";
        id[1]="Loop";
        id[2]="Function";

        name[0]="1";
        name[1]="2";
        name[2]="3";
        /*for(int i=0;i<name.length;i++)
        {
            name[i]= C_Description.c_description[i].getName();
        }*/

        /*for(int i=0;i<id.length;i++)
        {
            id[i]=  C_Description.c_description[i].getId();
        }*/

        CDescriptionsAdapter adapter=new CDescriptionsAdapter(id,name);
        recyclerView.setAdapter(adapter);

        RecyclerView.LayoutManager manager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);



        return recyclerView;
    }
}