package com.example.andriod.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

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

public class GetJsonArray extends AppCompatActivity {
    RequestQueue requestQueue;
    RecyclerView recyclerView;
    List<User> userList;
    public static final String TAG = GetJsonArray.class.getCanonicalName();
    public static final String URL = "http://www.mocky.io/v2/597c41390f0000d002f4dbd1";
    GetJsonArrayAapter getJsonArrayAapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_json_array);

        recyclerView = findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        userList = new ArrayList<>();

        callArray();
    }

    private void callArray() {
        Log.i(TAG, "callArray: ");
        requestQueue = Volley.newRequestQueue(this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("users");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject users = jsonArray.getJSONObject(i);
                        String id = users.getString("id");
                        String name = users.getString("name");
                        String email = users.getString("email");
                        String gender = users.getString("gender");

                        JSONObject contactObject = users.getJSONObject("contact");
                        String mobile = contactObject.getString("mobile");
                        String home = contactObject.getString("home");
                        String office = contactObject.getString("office");

                        Log.d("data", "\n" + mobile + "\t" + home + "\t" + office);
                        User user = new User(id,name,email,gender,mobile,home,office);
                        userList.add(user);
                    }
                    getJsonArrayAapter = new GetJsonArrayAapter(userList, GetJsonArray.this);
                    recyclerView.setAdapter(getJsonArrayAapter);

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
