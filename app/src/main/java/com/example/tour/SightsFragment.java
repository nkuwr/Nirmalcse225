package com.example.tour;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;


public class SightsFragment extends Fragment {

    static final String NAME = "Sights";

    public SightsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_fragment_nearby, container, false);

        ArrayList<TourItem> tourItems = new ArrayList<>();

        tourItems.add(new TourItem(getString(R.string.kim), getString(R.string.kimd), getString(R.string.kiml), R.drawable.kimadi));
        tourItems.add(new TourItem(getString(R.string.guchu), getString(R.string.guchuu), getString(R.string.guchul), R.drawable.guchhu));
        tourItems.add(new TourItem(getString(R.string.fri), getString(R.string.frii), getString(R.string.fril), R.drawable.fri));

        ListView listView = rootView.findViewById(R.id.nearby);
        TourAdapter tourAdapter = new TourAdapter(rootView.getContext(), tourItems);
        listView.setAdapter(tourAdapter);

        return rootView;
    }


}
