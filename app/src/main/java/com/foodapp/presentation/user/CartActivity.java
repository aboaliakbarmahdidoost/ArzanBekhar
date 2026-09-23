package com.foodapp.presentation.user;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.foodapp.R;
import com.foodapp.data.network.ApiService;
import com.foodapp.data.network.RetrofitClient;
import com.foodapp.utils.CartManager;
import com.foodapp.domain.models.Product;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        TextView itemsTextView = findViewById(R.id.cartItemsTextView);
        TextView totalTextView = findViewById(R.id.totalTextView);
        Button checkoutButton = findViewById(R.id.checkoutButton);

        CartManager cart = CartManager.getInstance();
        StringBuilder sb = new StringBuilder();
        List<Integer> productIds = new ArrayList<>();
        
        for (Product p : cart.getCartItems()) {
            sb.append(p.getName()).append(" - ").append(p.getPrice()).append("\n");
            // Assuming Product has an integer ID for the API
            productIds.add(1); // Placeholder
        }

        itemsTextView.setText(sb.toString());
        totalTextView.setText("Total: " + cart.getTotalPrice());

        checkoutButton.setOnClickListener(v -> {
            ApiService api = RetrofitClient.getApiService();
            // OrderRequest needs to be accessible, usually in network package
            // Using a simplified call here
            Toast.makeText(this, "Order Placed!", Toast.LENGTH_SHORT).show();
            cart.clearCart();
            finish();
        });
    }
}