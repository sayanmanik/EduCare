package com.example.a1605476.registrationapp.FragmentDirectory;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a1605476.registrationapp.Adapter.ListAdapter;
import com.example.a1605476.registrationapp.R;

public class Videos extends Fragment {

    RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_videos, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        ListAdapter listAdapter=new ListAdapter();
        mRecyclerView.setAdapter(listAdapter);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        return view;
    }
}