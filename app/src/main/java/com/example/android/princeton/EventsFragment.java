package com.example.android.princeton;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventsFragment extends Fragment {
    public EventsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.text_list, container, false);

        final ArrayList<ItemText> events = new ArrayList<ItemText>();

        events.add(new ItemText("West Windsor Community Farmer’s Market", "West Windsor, NJ", R.drawable.triumphpj));
        events.add(new ItemText("Communiversity", "Princeton, NJ", R.drawable.olivesenter));
        events.add(new ItemText("Music Fest", "Princeton, NJ", R.drawable.hoagie_haven));
        events.add(new ItemText("Princeton Pi Day", "Princeton, NJ", R.drawable.winberies));
        events.add(new ItemText("WWACF Summer Music", "Princeton, NJ", R.drawable.pjsprinceton));
        events.add(new ItemText("Independence Day Fireworks", "Hamilton, NJ", R.drawable.pjsprinceton));

        TextAdapter itemsAdapter = new TextAdapter(getActivity(), events, R.color.colorPrimary);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ItemText textItem = events.get(position);
            }
        });

        return rootView;
    }
}
