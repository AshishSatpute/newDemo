package com.example.andriod.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView name, email, mobile;
    public static final String URL = "https://simplifiedcoding.net/demos/view-flipper/heroes.php";
    RequestQueue requestQueue;
    public static final String TAG = MainActivity.class.getCanonicalName();
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    List<ListItem> listItems;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //creating cache and network
        /*Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024);
        Network network = new BasicNetwork(new HurlStack());
        requestQueue = new RequestQueue(cache, network);*/
        // requestQueue.start();


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        listItems = new ArrayList<>();

       /* for (int i = 0; i <= 10; i++) {
            ListItem listItem = new ListItem(
                    "heading" + i,
                    "title" + i
            );
            listItems.add(listItem);
        }
        adapter = new MyAdapter(listItems, this);
        recyclerView.setAdapter(adapter);*/

        show();
    }

    public void show() {
        Log.i(TAG, "show: ");
        requestQueue = Volley.newRequestQueue(MainActivity.this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("heroes");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject heroes = jsonArray.getJSONObject(i);
                        String name = heroes.getString("name");
                        String imageurl = heroes.getString("imageurl");
                        listItems.add(new ListItem(name, imageurl));
                    }
                    myAdapter = new MyAdapter(listItems, MainActivity.this);
                    recyclerView.setAdapter(myAdapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        MySingleTone.getInstance(getApplicationContext()).addToRequest(jsonObjectRequest);
        //requestQueue.add(stringRequest);
    }
}