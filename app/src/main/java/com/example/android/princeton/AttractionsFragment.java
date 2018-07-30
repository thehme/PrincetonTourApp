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
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AttractionsFragment extends Fragment {
    public AttractionsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.text_list, container, false);

        final ArrayList<ItemText> attractions = new ArrayList<ItemText>();

        attractions.add(new ItemText(this.getString(R.string.princeton_battlefield_name), this.getString(R.string.princeton_town), this.getString(R.string.princeton_battlefield_website), R.drawable.battlefieldpark));
        attractions.add(new ItemText(this.getString(R.string.princeton_chapel_name), this.getString(R.string.hamilton_town), this.getString(R.string.princeton_chapel_website), R.drawable.princetonchapel));
        attractions.add(new ItemText(this.getString(R.string.princeton_museum_name), this.getString(R.string.princeton_town), this.getString(R.string.princeton_museum_website), R.drawable.princetonart));
        attractions.add(new ItemText(this.getString(R.string.palmer_square_name), this.getString(R.string.princeton_town), this.getString(R.string.palmer_square_website), R.drawable.palmersquare));
        attractions.add(new ItemText(this.getString(R.string.turning_park_name), this.getString(R.string.princeton_town), this.getString(R.string.turning_park_website), R.drawable.turningbasin));
        attractions.add(new ItemText(this.getString(R.string.billie_johnson_park_name), this.getString(R.string.princeton_town), this.getString(R.string.billie_johnson_park_website), R.drawable.billiejohnsonmountainlakesnaturepreserve));
        attractions.add(new ItemText(this.getString(R.string.washington_park_name), this.getString(R.string.hopewell_town), this.getString(R.string.washington_park_website), R.drawable.washingtopark));

        TextAdapter itemsAdapter = new TextAdapter(getActivity(), attractions, R.color.colorPrimary);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ItemText textItem = attractions.get(position);
                String webAddress = textItem.getWebAddress();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(webAddress));
                startActivity(intent);
            }
        });

        return rootView;
    }
}
