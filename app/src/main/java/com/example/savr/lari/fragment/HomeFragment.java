package com.example.savr.lari.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.savr.lari.R;

import static com.example.savr.lari.R.drawable.user;

public class HomeFragment extends Fragment {
   private TextView namaUserTV,emailUSerTV;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_home, container, false);
        namaUserTV = (TextView) view.findViewById(R.id.namaTV);
        emailUSerTV = (TextView) view.findViewById(R.id.emailTV);

        namaUserTV.setText(getActivity().getIntent().getStringExtra("user"));
        emailUSerTV.setText(getActivity().getIntent().getStringExtra("email"));
        return view;
    }
}
