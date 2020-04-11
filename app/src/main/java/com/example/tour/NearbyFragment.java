package com.example.tour;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;


public class NearbyFragment extends Fragment {

    public static final String NAME = "Nearby";

    public NearbyFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_fragment_nearby, container, false);

        ArrayList<TourItem> tourItems = new ArrayList<>();
        tourItems.add(new TourItem(getString(R.string.george), getString(R.string.georged), getString(R.string.georgel), R.drawable.george));
        tourItems.add(new TourItem(getString(R.string.cloud), getString(R.string.cloudd), getString(R.string.cloudl), R.drawable.cloud));
        tourItems.add(new TourItem(getString(R.string.rishikesh), getString(R.string.rishikeshd), getString(R.string.rishikeshl), R.drawable.rishikesh));
        tourItems.add(new TourItem(getString(R.string.hari), getString(R.string.harid), getString(R.string.haril), R.drawable.haridwar));
        ListView listView = rootView.findViewById(R.id.nearby);
        TourAdapter tourAdapter = new TourAdapter(rootView.getContext(), tourItems);
        listView.setAdapter(tourAdapter);

        return rootView;
    }
}
