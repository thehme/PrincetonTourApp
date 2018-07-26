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
public class DessertCoffeeFragment extends Fragment {

    public DessertCoffeeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.text_list, container, false);

        final ArrayList<ItemText> dessertCoffeeShops = new ArrayList<ItemText>();

        dessertCoffeeShops.add(new ItemText("Halo Pub", "Princeton, NJ", R.drawable.triumphbrewing));
        dessertCoffeeShops.add(new ItemText("Halo Pub", "Hamilton, NJ", R.drawable.olivesenter));
        dessertCoffeeShops.add(new ItemText("Thomas Sweet", "Princeton, NJ", R.drawable.hoagie_haven));
        dessertCoffeeShops.add(new ItemText("House of Cupcakes", "Princeton, NJ", R.drawable.winberies));
        dessertCoffeeShops.add(new ItemText("Small World Coffee", "Princeton, NJ", R.drawable.pjsprinceton));
        dessertCoffeeShops.add(new ItemText("Kung Fu Tea & Noodle House", "Princeton, NJ", R.drawable.pjsprinceton));
        dessertCoffeeShops.add(new ItemText("Bent Spoon", "Princeton, NJ", R.drawable.pjsprinceton));

        TextAdapter itemsAdapter = new TextAdapter(getActivity(), dessertCoffeeShops, R.color.colorPrimary);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ItemText textItem = dessertCoffeeShops.get(position);
            }
        });

        return rootView;
    }
}
