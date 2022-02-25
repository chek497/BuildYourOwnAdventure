package com.example.buildyourownadventure;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class DictionaryActivity extends AppCompatActivity {

    final String TAG = "demo"; //for tag
    ListView listview;
    ArrayList<Spell_S> spellList = new ArrayList<>();

    SpellAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);

        Log.d(TAG, "onCreate: Dictionary"); //log successful launch
        setTitle("Spell Dictionary");

        listview = findViewById(R.id.listView);

        spellList.add(new Spell_S("Hideous Laughter", "A creature of your choice that you can see within range perceives everything as hilariously funny and falls into fits of laughter if this spell affects it. The target must succeed on a Wisdom saving throw or fall prone, becoming incapacitated and unable to stand up for the duration. A creature with an Intelligence score of 4 or less isn't affected.\n" +
                "At the end of each of its turns, and each time it takes damage, the target can make another Wisdom saving throw. The target has advantage on the saving throw if it's triggered by damage. On a success, the spell ends. "));
        spellList.add(new Spell_S("Bless", "You bless up to three creatures of your choice within range. Whenever a target makes an attack roll or a saving throw before the spell ends, the target can roll a d4 and add the number rolled to the attack roll or saving throw. "));
        spellList.add(new Spell_S("Jump", "You touch a creature. The creature's jump distance is tripled until the spell ends."));
        spellList.add(new Spell_S("Shield", "An invisible barrier of magical force appears and protects you. Until the start of your next turn, you have a +5 bonus to AC, including against the triggering attack, and you take no damage from magic missile. "));
        spellList.add(new Spell_S("Speak With Animals", "You gain the ability to comprehend and verbally communicate with beasts for the duration. The knowledge and awareness of many beasts is limited by their intelligence, but at minimum, beasts can give you information about nearby locations and monsters, including whatever they can perceive or have perceived within the past day. You might be able to persuade a beast to perform a small favor for you, at the GM's discretion. "));

        adapter = new SpellAdapter(this, R.layout.spell_row_item, spellList);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(DictionaryActivity.this, "hello", Toast.LENGTH_SHORT).show();
            }
        });
    }
}