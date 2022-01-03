package com.example.ex6_stock_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.VolleyError;

public class MainActivity extends AppCompatActivity {
    static String symbolString;
    TextView stockPrice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stockPrice = findViewById(R.id.stockPrice);
        Button searchSymbol = findViewById(R.id.searchSymbol);
        EditText symbol = findViewById(R.id.symbolInput);

        stockPrice.setVisibility(View.INVISIBLE);
        searchSymbol.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        symbolString = (String) symbol.getText().toString();
                        fetchPrice(v);
                    }
            });
    }


    public void fetchPrice(final View view) {
        final stockFetcher fetcher = new stockFetcher(view.getContext());

        fetcher.dispatchRequest(new stockFetcher.StockResponseListener() {
            @Override
            public void onResponse(stockFetcher.symbolResponse response) {
                if (response.price.equals("-")){
                    stockPrice.setText(R.string.not_found);
                }
                else{
                    stockPrice.setText(response.price);
                }
                stockPrice.setVisibility(View.VISIBLE);
            }
        });
    }
}