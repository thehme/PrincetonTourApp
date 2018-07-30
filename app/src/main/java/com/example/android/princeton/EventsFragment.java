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

        events.add(new ItemText(this.getString(R.string.farmers_market_name), this.getString(R.string.west_windsor_town), this.getString(R.string.farmers_market_website), R.drawable.wwfarmers));
        events.add(new ItemText(this.getString(R.string.farmers_market_name), this.getString(R.string.princeton_town), this.getString(R.string.communiversity_website), R.drawable.communiversitynj));
        events.add(new ItemText(this.getString(R.string.princeton_music_name), this.getString(R.string.princeton_town), this.getString(R.string.palmer_square_events_website), R.drawable.musicfest));
        events.add(new ItemText(this.getString(R.string.princeton_pi_name), this.getString(R.string.princeton_town), this.getString(R.string.princeton_pi_website), R.drawable.pidaypj));
        events.add(new ItemText(this.getString(R.string.wwacf_name), this.getString(R.string.princeton_town), this.getString(R.string.wwacf_website), R.drawable.wwac));
        events.add(new ItemText(this.getString(R.string.fireworks_name), this.getString(R.string.hamilton_town), this.getString(R.string.fireworks_website), R.drawable.riderjuly));
        events.add(new ItemText(this.getString(R.string.science_sat_name), this.getString(R.string.princeton_plasma), this.getString(R.string.science_sat_website), R.drawable.sciencesat));

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
