package com.example.a1605476.registrationapp.FragmentDirectory;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a1605476.registrationapp.Adapter.ListAdapter1;
import com.example.a1605476.registrationapp.R;

public class Quiz extends Fragment
{
    RecyclerView nrecyclerView;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_quiz, container, false);
        nrecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        ListAdapter1 listAdapter1=new ListAdapter1();
        nrecyclerView.setAdapter(listAdapter1);
        RecyclerView.LayoutManager layoutManager1=new LinearLayoutManager(getActivity());
        nrecyclerView.setLayoutManager(layoutManager1);
        return view;
    }
}
