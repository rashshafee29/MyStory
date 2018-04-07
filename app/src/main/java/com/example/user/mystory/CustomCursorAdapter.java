package com.example.user.mystory;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class CustomCursorAdapter extends CursorAdapter {
    public CustomCursorAdapter(Context context, Cursor c) {
        super(context, c);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View retView = inflater.inflate(R.layout.single_list, parent, false);
        return retView;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView titleStory = (TextView)view.findViewById(R.id.titleStory);
        titleStory.setText(cursor.getString(cursor.getColumnIndex(cursor.getColumnName(1))));

        TextView aboutStory = (TextView)view.findViewById(R.id.aboutStory);
        aboutStory.setText(cursor.getString(cursor.getColumnIndex(cursor.getColumnName(2))));
    }
}
