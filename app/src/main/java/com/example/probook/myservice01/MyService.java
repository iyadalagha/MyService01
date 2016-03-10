package com.example.probook.myservice01;

import android.app.IntentService;
import android.app.Notification;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by PROBOOK on 3/10/2016.
 */
public class MyService extends IntentService {

    public MyService(){
        super("sss");

    }

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public MyService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext());
        builder.setContentTitle("t");
        builder.setContentText("text");
        Notification n = builder.build();
        this.startForeground(1, n);

        for(int i=0; i<10;i++){
            Log.i("ttt", "Running : "+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        Intent i = new Intent("abcde");
        i.putExtra("data","Thank you");
        sendBroadcast(i);

        /*
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url = "http://httpbin.org/ip";
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("ttt", response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("ttt", error.getMessage());
            }
        });
        queue.add(request);
        */
    }
}
