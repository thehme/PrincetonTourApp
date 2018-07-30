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

        attractions.add(new ItemText("Princeton Battlefield State Park", "Princeton, NJ", "https://www.nj.gov/dep/parksandforests/parks/princeton.html", R.drawable.battlefieldpark));
        attractions.add(new ItemText("Princeton University Chapel", "Hamilton, NJ", "http://religiouslife.princeton.edu/chapel", R.drawable.princetonchapel));
        attractions.add(new ItemText("Princeton University Art Museum", "Princeton, NJ", "http://artmuseum.princeton.edu", R.drawable.princetonart));
        attractions.add(new ItemText("Palmer Square", "Princeton, NJ", "https://www.palmersquare.com", R.drawable.palmersquare));
        attractions.add(new ItemText("Turning Basin Park", "Princeton, NJ", "https://www.princetonnj.gov/location/turning-basin-park", R.drawable.turningbasin));
        attractions.add(new ItemText("Billie Johnson Mountain Lakes Nature Preserve", "Princeton, NJ", "http://njtrails.org/trail/mountain-lakes-open-space-area", R.drawable.billiejohnsonmountainlakesnaturepreserve));
        attractions.add(new ItemText("Washington Crossing State Park", "Hopewell Township, NJ", "https://www.state.nj.us/dep/parksandforests/parks/washcros.html", R.drawable.washingtopark));

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
