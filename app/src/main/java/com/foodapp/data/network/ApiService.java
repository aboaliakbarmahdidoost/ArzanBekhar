package com.foodapp.data.network;

import com.foodapp.domain.models.Investor;
import com.foodapp.domain.models.Product;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    @GET("investors")
    Call<List<Investor>> getInvestors();

    @POST("investors")
    Call<Void> addInvestor(@Body Investor investor);

    @GET("products")
    Call<List<Product>> getProducts();

    @POST("orders")
    Call<Void> placeOrder(@Body OrderRequest request);

    @POST("profit/calculate")
    Call<ProfitResponse> calculateProfit();
}

class OrderRequest {
    public int user_id;
    public List<Integer> items;
    public OrderRequest(int user_id, List<Integer> items) {
        this.user_id = user_id;
        this.items = items;
    }
}

class ProfitResponse {
    public double total_profit;
}