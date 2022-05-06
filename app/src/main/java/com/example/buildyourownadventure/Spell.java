package com.example.buildyourownadventure;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

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

public class Spell extends AppCompatActivity {
    List<String> parentList;
    List<String> descList;
    List<String> classesList;
    List<String> subClassesList;
    Map<String, List<String>> collection;
    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    private final OkHttpClient client = new OkHttpClient();

    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        String spell = intent.getStringExtra("spell");
        String urlSpell = spell.replaceAll(" ", "-").toLowerCase();
        String url = "https://www.dnd5eapi.co/api/spells/" + urlSpell;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.monsterdetails);
        setTitle(spell);
        parentList = new ArrayList<>();
        descList = new ArrayList<>();
        classesList = new ArrayList<>();
        subClassesList = new ArrayList<>();
        collection = new HashMap<>();

        parentList.add("Description");
        parentList.add("Classes");
        parentList.add("Subclasses");
        Request request = new Request.Builder()
                .url(url)
                .build();

        for(String parent: parentList){
            switch(parent){
                case "Description":
                    collection.put(parent, descList);
                    break;
                case "Classes":
                    collection.put(parent, classesList);
                    break;
                case "Subclasses":

                    collection.put(parent, subClassesList);

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
                        JSONArray description = jsonObject.getJSONArray("desc");
                        JSONArray classes = jsonObject.getJSONArray("classes");
                        JSONArray subClasses = jsonObject.getJSONArray("subclasses");

                        descList.add(description.get(0).toString());
                        if(classes.length() != 0) {
                            for (int i = 0; i < classes.length(); i++) {
                                JSONObject object = classes.getJSONObject(i);
                                String name = object.getString("name");

                                classesList.add(name);
                            }
                        } else{
                            classesList.add("None");
                        }
                        if(subClasses.length() != 0) {
                            for (int i = 0; i < subClasses.length(); i++) {
                                JSONObject object = subClasses.getJSONObject(i);
                                String name = object.getString("name");
                                subClassesList.add(name);
                            }
                        }else{
                            subClassesList.add("None");
                        }
                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {

                                // Stuff that updates the UI

                                expandableListAdapter = new MyExpandableListAdapter(Spell.this, parentList, collection);
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
