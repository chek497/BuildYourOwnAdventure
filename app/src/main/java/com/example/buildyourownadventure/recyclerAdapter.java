package com.example.buildyourownadventure;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.CharacterRecyclerView> {
    private ArrayList<Character> character;

    public recyclerAdapter(ArrayList<Character> character){
        this.character = character;
    }

    public class CharacterRecyclerView extends  RecyclerView.ViewHolder{
        private TextView name;
        private TextView Class;
        private TextView race;
       //public ImageView face;

        public CharacterRecyclerView(final View view){
            super(view);
            name = view.findViewById(R.id.textView17);
            Class = view.findViewById(R.id.textView18);
            race = view.findViewById(R.id.textView20);
            //face = view.findViewById(R.id.imageView3);
        }
    }

    @NonNull
    @Override
    public recyclerAdapter.CharacterRecyclerView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.character_list, parent, false);
        return new CharacterRecyclerView(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerAdapter.CharacterRecyclerView holder, int position) {
        String name = character.get(position).getName();
        String Class = character.get(position).getCharacterClass();
        String race = character.get(position).getRace();
        //Image face = character.get(position).getFace();

        holder.name.setText(name);
        holder.Class.setText(Class);
        holder.race.setText(race);
        //holder.face.setImageResource(position);
    }

    @Override
    public int getItemCount() {
        return character.size();
    }
}
