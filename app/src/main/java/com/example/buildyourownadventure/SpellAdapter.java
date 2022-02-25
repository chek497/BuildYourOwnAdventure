package com.example.buildyourownadventure;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class SpellAdapter extends ArrayAdapter<Spell_S> {
    public SpellAdapter(@NonNull Context context, int resource, @NonNull List<Spell_S> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.spell_row_item,parent,false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.textViewName = convertView.findViewById(R.id.textViewName);
            viewHolder.textViewDescription = convertView.findViewById(R.id.textViewDescription);
            convertView.setTag(viewHolder);
        }
        Spell_S spell = getItem(position);
        ViewHolder viewHolder = (ViewHolder) convertView.getTag();
        //Option 1. Do this, no ViewHolder class to hold the view.
        //Downside: It's slower because you're accessing convertView every time you use getView
        //instead of holding getView if convert isn't null. I don't fully understand this yet.
//        TextView textViewName = convertView.findViewById(R.id.textViewName);
//        TextView textViewDescription = convertView.findViewById(R.id.textViewDescription);
        viewHolder.textViewName.setText(spell.name);
        viewHolder.textViewDescription.setText(spell.description);

        return convertView;
    }

    private static class ViewHolder{
        TextView textViewName;
        TextView textViewDescription;
    }
}
