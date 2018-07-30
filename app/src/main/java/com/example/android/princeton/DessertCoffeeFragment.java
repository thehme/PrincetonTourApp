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

        dessertCoffeeShops.add(new ItemText(this.getString(R.string.halo_pub_name), this.getString(R.string.princeton_town), this.getString(R.string.halo_pub_princeton_website), R.drawable.halopubp));
        dessertCoffeeShops.add(new ItemText(this.getString(R.string.halo_pub_name), this.getString(R.string.hamilton_town), this.getString(R.string.halo_pub_hamilton_website), R.drawable.halopubh));
        dessertCoffeeShops.add(new ItemText(this.getString(R.string.thomas_sweet_name), this.getString(R.string.princeton_town), this.getString(R.string.thomas_sweet_website), R.drawable.thomassweet));
        dessertCoffeeShops.add(new ItemText(this.getString(R.string.house_cupcakes_name), this.getString(R.string.princeton_town), this.getString(R.string.house_cupcakes_website), R.drawable.houseofcupcakes));
        dessertCoffeeShops.add(new ItemText(this.getString(R.string.small_world_name), this.getString(R.string.princeton_town), this.getString(R.string.small_world_website), R.drawable.smallworldcoffee));
        dessertCoffeeShops.add(new ItemText(this.getString(R.string.kung_fu_name), this.getString(R.string.princeton_town), this.getString(R.string.kung_fu_website), R.drawable.kungfutea));
        dessertCoffeeShops.add(new ItemText(this.getString(R.string.bent_spoon_name), this.getString(R.string.princeton_town), this.getString(R.string.bent_spoon_website), R.drawable.bentspoon));

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
