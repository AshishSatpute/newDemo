package com.example.andriod.myapplication;

import android.content.Context;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.Volley;

public class MySingleTone {

    private RequestQueue requestQueue;
    private static MySingleTone myInstance;
    private static Context mCtx;

    private MySingleTone(Context context) {
        mCtx = context;
        requestQueue = getRequestQueue();
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return requestQueue;
    }

    public static synchronized MySingleTone getInstance(Context context) {
        if (myInstance == null) {
            myInstance = new MySingleTone(context);
        }
        return myInstance;
    }

    public <T> void addToRequest(Request<T> request) {
        requestQueue.add(request);
    }

}
