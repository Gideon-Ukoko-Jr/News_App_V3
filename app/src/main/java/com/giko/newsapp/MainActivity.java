package com.giko.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private EditText etSearchBar;
    private ImageView filterButton;
    private RecyclerView recyclerViewSources;

    private ArrayList<ModelSourceList> modelSourceLists;
    private AdapterSourceList adapterSourceList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
        etSearchBar = findViewById(R.id.etSearchBar);
        filterButton = findViewById(R.id.filterButton);
        recyclerViewSources = findViewById(R.id.recViewSources);

        loadSources();
    }

    private void loadSources(){
        modelSourceLists = new ArrayList<>();
        modelSourceLists.clear();

        progressBar.setVisibility(View.VISIBLE);

        String url = "https://newsapi.org/v2/sources?apiKey=" + Constants.API_KEY;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("sources");

                    for (int i=0; i<jsonArray.length(); i++){
                        JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                        String id = jsonObject1.getString("id");
                        String name = jsonObject1.getString("name");
                        String description = jsonObject1.getString("description");
                        String url = jsonObject1.getString("url");
                        String country = jsonObject1.getString("country");
                        String category = jsonObject1.getString("category");
                        String language = jsonObject1.getString("language");

                        ModelSourceList msl = new ModelSourceList(
                                ""+id,
                                ""+name,
                                ""+description,
                                ""+url,
                                ""+category,
                                ""+language,
                                ""+country
                        );

                        modelSourceLists.add(msl);

                    }

                    progressBar.setVisibility(View.GONE);

                    adapterSourceList = new AdapterSourceList(MainActivity.this, modelSourceLists);
                    recyclerViewSources.setAdapter(adapterSourceList);

                }catch (Exception e){
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(MainActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, ""+error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        //Add Request to Queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
}