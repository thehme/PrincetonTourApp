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
public class RestaurantsFragment extends Fragment {


    public RestaurantsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.text_list, container, false);

        final ArrayList<ItemText> restaurants = new ArrayList<ItemText>();

        restaurants.add(new ItemText("Triumph Brewery", "Princeton, NJ", "www" , R.drawable.triumphbrewing));
        restaurants.add(new ItemText("Olives Catering", "Princeton, NJ", "www" , R.drawable.olivesenter));
        restaurants.add(new ItemText("Hoagie Haven", "Princeton, NJ", "www" , R.drawable.hoagie_haven));
        restaurants.add(new ItemText("Winberie\'s Restaurant & Bar", "Princeton, NJ", "www" , R.drawable.winberies));
        restaurants.add(new ItemText("PJ’s Pancake House", "Princeton, NJ", "www" , R.drawable.pjsprinceton));
        restaurants.add(new ItemText("PJ’s Pancake House", "West Windsor, NJ", "www" , R.drawable.pjswestwindsor));
        restaurants.add(new ItemText("Kung Fu Tea & Noodle House", "Princeton, NJ", "www" , R.drawable.pjsprinceton));

        TextAdapter itemsAdapter = new TextAdapter(getActivity(), restaurants, R.color.colorPrimary);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ItemText textItem = restaurants.get(position);
            }
        });

        return rootView;
    }
}
