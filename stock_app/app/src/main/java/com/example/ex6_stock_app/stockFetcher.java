package com.example.ex6_stock_app;

import android.content.Context;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class stockFetcher {
    private RequestQueue _queue;
    private final static String REQUEST_URL = "http://10.0.2.2:5000/stock?symbol=%s";

    public stockFetcher(Context context) {
        _queue = Volley.newRequestQueue(context);
    }

    public class symbolResponse {

        public String symbol;
        public String price;

        public symbolResponse(String symbol,  String price) {
            this.symbol = symbol;
            this.price = price;
        }
    }

    public interface StockResponseListener {
        public void onResponse(symbolResponse response);
    }

    public void dispatchRequest(final StockResponseListener listener) {
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET, String.format(REQUEST_URL,MainActivity.symbolString), null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            symbolResponse res = new symbolResponse(
                                    response.getString("symbol"),
                                    response.getString("price"));
                            listener.onResponse(res);

                        } catch (JSONException e) {
                            listener.onResponse(new symbolResponse(e.getMessage(),"-"));
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onResponse(new symbolResponse(error.getMessage(),"-"));
            }
        });

        _queue.add(req);
    }
}
