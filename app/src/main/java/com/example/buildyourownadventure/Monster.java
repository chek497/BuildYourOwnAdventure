package com.example.buildyourownadventure;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Monster extends AppCompatActivity {
    List<String> parentList;
    List<String> actionList;
    List<String> legendaryList;
    List<String> specialList;
    Map<String, List<String>> collection;
    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    private final OkHttpClient client = new OkHttpClient();

    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        String monster = intent.getStringExtra("monster");
        String urlMonster = monster.replaceAll(" ", "-").toLowerCase();
        String url = "https://www.dnd5eapi.co/api/monsters/" + urlMonster;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.monsterdetails);
        setTitle(monster);
        parentList = new ArrayList<>();
        actionList = new ArrayList<>();
        legendaryList = new ArrayList<>();
        specialList = new ArrayList<>();
        collection = new HashMap<>();

        parentList.add("Actions");
        parentList.add("Legendary Actions");
        parentList.add("Special Abilities");
        Request request = new Request.Builder()
                .url(url)
                .build();

        for(String parent: parentList){
            switch(parent){
                case "Actions":
                    collection.put(parent, actionList);
                    break;
                case "Legendary Actions":
                    collection.put(parent, legendaryList);
                    break;
                case "Special Abilities":

                    collection.put(parent, specialList);

                    break;
            }
        }
        //asynchronous
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Response response) throws IOException {
                if(response.isSuccessful()) {
                    try {
                        JSONObject jsonObject = new JSONObject(response.body().string());
                        JSONArray actions = jsonObject.getJSONArray("actions");
                        JSONArray legendary = jsonObject.getJSONArray("legendary_actions");
                        JSONArray special = jsonObject.getJSONArray("special_abilities");

                        if(actions.length() != 0) {
                            for (int i = 0; i < actions.length(); i++) {
                                JSONObject object = actions.getJSONObject(i);
                                String name = object.getString("name");
                                String desc = object.getString("desc");
                                String child = "Name: " + name + "\n\nDescription\n\n" + desc;
                                actionList.add(child);
                            }
                        }else{
                            actionList.add("None");
                        }
                        if(legendary.length() != 0) {
                            for (int i = 0; i < legendary.length(); i++) {
                                JSONObject object = legendary.getJSONObject(i);
                                String name = object.getString("name");
                                String desc = object.getString("desc");
                                String child = "Name: " + name + "\n\nDescription\n\n" + desc;
                                legendaryList.add(child);
                            }
                        } else{
                            legendaryList.add("None");
                        }
                        if(special.length() != 0) {
                            for (int i = 0; i < special.length(); i++) {
                                JSONObject object = special.getJSONObject(i);
                                String name = object.getString("name");
                                String desc = object.getString("desc");
                                String child = "Name: " + name + "\n\nDescription\n\n" + desc;
                                specialList.add(child);
                            }
                        }else{
                            specialList.add("None");
                        }
                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {

                                // Stuff that updates the UI

                                expandableListAdapter = new MyExpandableListAdapter(Monster.this, parentList, collection);
                                expandableListView = findViewById(R.id.details);
                                expandableListView.setAdapter(expandableListAdapter);
                                expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
                                    int lastExpandedPosition = -1;
                                    @Override
                                    public void onGroupExpand(int i) {
                                        if(lastExpandedPosition != -1 && lastExpandedPosition != i){
                                            expandableListView.collapseGroup(lastExpandedPosition);
                                        }
                                        lastExpandedPosition = i;

                                    }
                                });

                            }
                        });


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }

            }
        });

    }
}
