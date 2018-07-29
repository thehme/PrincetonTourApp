package com.example.android.princeton;

import android.content.Intent;
import android.net.Uri;
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

        events.add(new ItemText("Community Farmer’s Market", "West Windsor, NJ", "http://www.westwindsorfarmersmarket.org", R.drawable.wwfarmers));
        events.add(new ItemText("Communiversity", "Princeton, NJ", "http://artscouncilofprinceton.org/communiversity", R.drawable.communiversitynj));
        events.add(new ItemText("Music Fest Princeton", "Princeton, NJ", "https://www.palmersquare.com/events", R.drawable.musicfest));
        events.add(new ItemText("Princeton Pi Day", "Princeton, NJ", "https://princetontourcompany.com/activities/pi-day", R.drawable.pidaypj));
        events.add(new ItemText("WWACF Summer Music", "Princeton, NJ", "https://westwindsorarts.org/events", R.drawable.pjsprinceton));
        events.add(new ItemText("Independence Day Fireworks", "Hamilton, NJ", "https://www.rider.edu/events/independence-day-fireworks", R.drawable.pjsprinceton));
        events.add(new ItemText("SCIENCE ON SATURDAY Lecture Series", "Princeton Plasma Physics Laboratory", "https://www.pppl.gov/education/science-education/programs/ronald-e-hatcher-science-saturday-lecture-series", R.drawable.pjsprinceton));

        TextAdapter itemsAdapter = new TextAdapter(getActivity(), events, R.color.colorPrimary);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ItemText textItem = events.get(position);
                String webAddress = textItem.getWebAddress();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(webAddress));
                startActivity(intent);
            }
        });

        return rootView;
    }
}
