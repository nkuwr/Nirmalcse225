package com.example.tour;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;


public class MallFragment extends Fragment {

    public static final String NAME = "Malls";

    public MallFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_fragment_nearby, container, false);

        ArrayList<TourItem> tourItems = new ArrayList<>();

        tourItems.add(new TourItem(getString(R.string.pac), getString(R.string.pacl), R.drawable.pacific));
        tourItems.add(new TourItem(getString(R.string.times), getString(R.string.timesl), R.drawable.times));

        ListView listView = rootView.findViewById(R.id.nearby);
        TourAdapter tourAdapter = new TourAdapter(rootView.getContext(), tourItems);
        listView.setAdapter(tourAdapter);

        return rootView;
    }

}
