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

        restaurants.add(new ItemText(this.getString(R.string.agricola_name), this.getString(R.string.princeton_town), this.getString(R.string.agricola_website), R.drawable.agricolapj));
        restaurants.add(new ItemText(this.getString(R.string.triumph_name), this.getString(R.string.princeton_town), this.getString(R.string.triumph_website), R.drawable.triumphpj));
        restaurants.add(new ItemText(this.getString(R.string.olives_name), this.getString(R.string.princeton_town), this.getString(R.string.olives_website), R.drawable.olivespj));
        restaurants.add(new ItemText(this.getString(R.string.hoagie_name), this.getString(R.string.princeton_town), this.getString(R.string.hoagie_website), R.drawable.hoagie_haven));
        restaurants.add(new ItemText(this.getString(R.string.winberies_name), this.getString(R.string.princeton_town), this.getString(R.string.winberies_website), R.drawable.winberies));
        restaurants.add(new ItemText(this.getString(R.string.pjs_name), this.getString(R.string.princeton_town), this.getString(R.string.pjs_website), R.drawable.pjsprinceton));
        restaurants.add(new ItemText(this.getString(R.string.pjs_name), this.getString(R.string.west_windsor_town), this.getString(R.string.pjs_website), R.drawable.pjswestwindsor));
        restaurants.add(new ItemText(this.getString(R.string.asian_bistro_name), this.getString(R.string.princeton_junction_town), this.getString(R.string.asian_bistro_website), R.drawable.asianbistropj));

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
