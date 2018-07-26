package com.example.android.princeton;

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

        attractions.add(new ItemText("Princeton Battlefield State Park", "Princeton, NJ", R.drawable.triumphbrewing));
        attractions.add(new ItemText("Princeton University Chapel", "Hamilton, NJ", R.drawable.olivesenter));
        attractions.add(new ItemText("Princeton University Art Museum", "Princeton, NJ", R.drawable.hoagie_haven));
        attractions.add(new ItemText("Palmer Square", "Princeton, NJ", R.drawable.winberies));
        attractions.add(new ItemText("Turning Basin Park", "Princeton, NJ", R.drawable.pjsprinceton));
        attractions.add(new ItemText("Billie Johnson Mountain Lakes Nature Preserve", "Princeton, NJ", R.drawable.pjsprinceton));
        attractions.add(new ItemText("Washington Crossing State Park", "Hopewell Township, NJ", R.drawable.pjsprinceton));

        TextAdapter itemsAdapter = new TextAdapter(getActivity(), attractions, R.color.colorPrimary);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ItemText textItem = attractions.get(position);
            }
        });

        return rootView;
    }
}
