package com.example.android.princeton;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
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

        restaurants.add(new ItemText("Agricola", "Princeton, NJ", "https://www.agricolaeatery.com" , R.drawable.agricolapj));
        restaurants.add(new ItemText("Triumph Brewery", "Princeton, NJ", "http://www.triumphbrewing.com" , R.drawable.triumphpj));
        restaurants.add(new ItemText("Olives Catering", "Princeton, NJ", "https://olivesprinceton.com" , R.drawable.olivespj));
        restaurants.add(new ItemText("Hoagie Haven", "Princeton, NJ", "http://hoagiehaven.com" , R.drawable.hoagie_haven));
        restaurants.add(new ItemText("Winberie\'s Restaurant & Bar", "Princeton, NJ", "http://princeton.winberies.com" , R.drawable.winberies));
        restaurants.add(new ItemText("PJ’s Pancake House", "Princeton, NJ", "http://www.pancakes.com" , R.drawable.pjsprinceton));
        restaurants.add(new ItemText("PJ’s Pancake House", "West Windsor, NJ", "http://www.pancakes.com" , R.drawable.pjswestwindsor));
        restaurants.add(new ItemText("Asian Bistro", "Princeton Junction, NJ", "https://www.orderstart.com/asianbistronj" , R.drawable.asianbistropj));

        TextAdapter itemsAdapter = new TextAdapter(getActivity(), restaurants, R.color.colorPrimary);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ItemText textItem = restaurants.get(position);
                String webAddress = textItem.getWebAddress();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(webAddress));
                startActivity(intent);
            }
        });

        return rootView;
    }
}
