package com.example.buildyourownadventure;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class MonsterLibrary extends AppCompatActivity {
    private static final String TAG = "Request";
    ListView listView;
    private final OkHttpClient client = new OkHttpClient();
    ArrayList<String> arrayList;
    ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libraries);
        setTitle("Monsters");
        listView = findViewById(R.id.libraries);
        arrayList = new ArrayList<>();
        Request request = new Request.Builder()
                .url("https://www.dnd5eapi.co/api/monsters")
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

                                arrayAdapter = new ArrayAdapter(
                                        MonsterLibrary.this,
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

                Intent intent = new Intent(MonsterLibrary.this, Monster.class);
                intent.putExtra("monster", adapterView.getItemAtPosition(i).toString());
                startActivity(intent);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);

        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Type here to search");


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                arrayAdapter.getFilter().filter(newText);

                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}
