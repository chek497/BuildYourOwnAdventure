package com.example.buildyourownadventure;




import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


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


public class DndLibraries extends AppCompatActivity {
    final String TAG = "demo"; //for tag
    private final OkHttpClient client = new OkHttpClient();
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libraries);
        Log.d(TAG, "onCreate: Libraries"); //log successful launch
        setTitle("Libraries");

        listView = findViewById(R.id.libraries);
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("Monsters");
        arrayList.add("Spells");
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.list_items, android.R.id.text1, arrayList);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View v, int i, long l) {
                if(i == 0){
                    Intent monstersIntent = new Intent(DndLibraries.this, MonsterLibrary.class);
                    startActivity(monstersIntent);
               }
                else if(i == 1){
                    Intent spellsIntent = new Intent(DndLibraries.this, SpellLibrary.class);
                    startActivity(spellsIntent);
                }
                else{
                    return;
                }



            }
        });


    }
    public void onClick(View v){
        Request request = new Request.Builder()
                .url("https://www.dnd5eapi.co/api/monsters")
                .build();

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
                        JSONArray classes = jsonObject.getJSONArray("results");
                        for(int i = 0;i<classes.length();i++){
                            JSONObject names = classes.getJSONObject(i);
                            String name = names.getString("name");
                            Log.d(TAG, name);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }

            }
        });
    }


}
