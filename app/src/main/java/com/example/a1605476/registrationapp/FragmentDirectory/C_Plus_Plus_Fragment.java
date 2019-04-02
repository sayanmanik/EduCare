package com.example.a1605476.registrationapp.FragmentDirectory;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a1605476.registrationapp.R;

/**
 * Created by 1605476 on 29-Mar-18.
 */

public class C_Plus_Plus_Fragment extends Fragment
{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        RecyclerView recyclerView=(RecyclerView) inflater.inflate(R.layout.fragment_c_plus_plus,container,false);
        return recyclerView;
    }
}
