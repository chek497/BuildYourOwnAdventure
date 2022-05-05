package com.example.buildyourownadventure;

import android.content.Intent;
import android.os.Bundle;
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

public class SpellLibrary extends AppCompatActivity {
    private static final String TAG = "Request";
    ListView listView;
    private final OkHttpClient client = new OkHttpClient();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libraries);
        setTitle("Spells");
        listView = findViewById(R.id.libraries);
        ArrayList<String> arrayList = new ArrayList<>();
        Request request = new Request.Builder()
                .url("https://www.dnd5eapi.co/api/spells")
                .build();

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
                        JSONArray classes = jsonObject.getJSONArray("results");
                        for(int i = 0;i<classes.length();i++){
                            JSONObject names = classes.getJSONObject(i);
                            String name = names.getString("name");

                            arrayList.add(name);

                        }
                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {

                                // Stuff that updates the UI

                                ArrayAdapter arrayAdapter = new ArrayAdapter(
                                        SpellLibrary.this,
                                        R.layout.list_items,
                                        android.R.id.text1, arrayList);
                                listView.setAdapter(arrayAdapter);

                            }
                        });
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }

            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View v, int i, long l) {

                Intent intent = new Intent(SpellLibrary.this, Spell.class);
                intent.putExtra("spell", adapterView.getItemAtPosition(i).toString());
                startActivity(intent);
            }
        });
    }
}
