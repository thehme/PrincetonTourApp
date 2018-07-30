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
public class DessertCoffeeFragment extends Fragment {

    public DessertCoffeeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.text_list, container, false);

        final ArrayList<ItemText> dessertCoffeeShops = new ArrayList<ItemText>();

        dessertCoffeeShops.add(new ItemText("Halo Pub", "Princeton, NJ", "https://www.palmersquare.com/directory/halo-pub", R.drawable.halopubp));
        dessertCoffeeShops.add(new ItemText("Halo Pub", "Hamilton, NJ", "https://www.yelp.com/biz/halo-pub-hamilton-square" , R.drawable.halopubh));
        dessertCoffeeShops.add(new ItemText("Thomas Sweet", "Princeton, NJ", "http://www.thomassweet.com", R.drawable.thomassweet));
        dessertCoffeeShops.add(new ItemText("House of Cupcakes", "Princeton, NJ", "https://houseofcupcakes.com", R.drawable.houseofcupcakes));
        dessertCoffeeShops.add(new ItemText("Small World Coffee", "Princeton, NJ", "http://smallworldcoffee.com", R.drawable.smallworldcoffee));
        dessertCoffeeShops.add(new ItemText("Kung Fu Tea & Noodle House", "Princeton, NJ", "https://www.yelp.com/biz/kung-fu-tea-princeton-6", R.drawable.kungfutea));
        dessertCoffeeShops.add(new ItemText("Bent Spoon", "Princeton, NJ", "http://www.thebentspoon.net", R.drawable.bentspoon));

        TextAdapter itemsAdapter = new TextAdapter(getActivity(), dessertCoffeeShops, R.color.colorPrimary);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ItemText textItem = dessertCoffeeShops.get(position);
                String webAddress = textItem.getWebAddress();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(webAddress));
                startActivity(intent);
            }
        });

        return rootView;
    }
}
