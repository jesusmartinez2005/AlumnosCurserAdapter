package com.example.jesusmartinez.alumnoscurseradapter;

import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by jesusmartinez on 26/12/15.
 */
final class ContactsCursorAdapter extends ResourceCursorAdapter {
    private LayoutInflater mInflater;
    public ContactsCursorAdapter(Context context, Cursor c) { super(context, android.R.layout.simple_list_item_2, c, 0);
        mInflater = LayoutInflater.from(context); }
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view = mInflater.inflate(android.R.layout.simple_list_item_2, parent, false);
        ViewHolder holder = new ViewHolder();
        TextView text1 = (TextView) view.findViewById(android.R.id.text1);
        TextView text2 = (TextView) view.findViewById(android.R.id.text2);
        holder.text1 = text1;
        holder.text2 = text2;
        view.setTag(holder);
        return view; }

    @Override
    public void bindView(View v, Context context, Cursor c) {
        ViewHolder holder = (ViewHolder) v.getTag();
        String nombre = c.getString(c.getColumnIndex("nombre"));
        String grupo = c.getString(c.getColumnIndex("grupo"));
        holder.text1.setText(nombre);
        holder.text2.setText(grupo);
    }


    public class ViewHolder {
        TextView text1;
        TextView text2;
    }
}