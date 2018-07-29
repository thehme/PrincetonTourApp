package com.example.android.princeton;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;

public class TextAdapter extends ArrayAdapter<ItemText> {
    /** background color for list_item **/
    public int mColorResourceId;

    public TextAdapter(Activity context, ArrayList<ItemText> texts, int backgroundColorResourceId) {
        super(context, 0, texts);
        mColorResourceId = backgroundColorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link current work} object located at this position in the list
        ItemText currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID name_text_view
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.name_text_view);
        // Get the version name from the current Word object and
        // set this text on the name TextView
        nameTextView.setText(currentWord.getName());

        // Find the TextView in the list_item.xml layout with the ID town_name_text_view
        TextView numberTextView = (TextView) listItemView.findViewById(R.id.town_name_text_view);
        // Get the version number from the current Word object and
        // set this text on the number TextView
        numberTextView.setText(currentWord.getTown());

        //Find the ImageView in the list_item.xml layout with the ID list_item_image
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.list_item_image);
        iconView.setVisibility(View.VISIBLE);
        iconView.setImageResource(currentWord.getImageResourceId());

        View textContainer = listItemView.findViewById(R.id.text_container);
        // determine color to be used in background
        int backgroundColor = ContextCompat.getColor(getContext(), mColorResourceId);
        textContainer.setBackgroundColor(backgroundColor);

        //Find the TextView in the list_item.xml layout with the ID web_text_view
        TextView webAddressView = (TextView) listItemView.findViewById(R.id.web_text_view);
        webAddressView.setText(currentWord.getWebAddress());

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
