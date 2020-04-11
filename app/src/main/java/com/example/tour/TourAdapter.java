package com.example.tour;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;


public class TourAdapter extends ArrayAdapter<TourItem> {

    private Context mContext;

    TourAdapter(Context context, ArrayList<TourItem> tourItemArrayList) {
        super(context, 0, tourItemArrayList);
        mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TourItem tourItem = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.img);
        TextView titleTextView = convertView.findViewById(R.id.title);
        TextView descTextView = convertView.findViewById(R.id.desc);
        TextView locTextView = convertView.findViewById(R.id.add);

        assert tourItem != null;
        imageView.setImageResource(tourItem.getImage());
        titleTextView.setText(tourItem.getTitle());
        descTextView.setText(tourItem.getEventDesc());
        locTextView.setText(tourItem.getLocation());

        return convertView;
    }
}
