package com.foodapp.presentation.investor;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.foodapp.R;
import com.foodapp.data.network.RetrofitClient;
import com.foodapp.data.network.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InvestorActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_investor);

        TextView profitTextView = findViewById(R.id.profitTextView);

        RetrofitClient.getApiService().calculateProfit().enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                if (response.isSuccessful()) {
                    profitTextView.setText("Annual Profit Shared: " + response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                profitTextView.setText("Error fetching profit");
            }
        });
    }
}