package com.foodapp.presentation.product;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.foodapp.R;

public class ProductActivity extends AppCompatActivity {
    private ProductViewModel viewModel;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        
        viewModel = new ViewModelProvider(this).get(ProductViewModel.class);
        RecyclerView recyclerView = findViewById(R.id.productRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        
        viewModel.getProducts().observe(this, products -> {
            // Update RecyclerView Adapter
        });
        
        viewModel.loadProducts();
    }
}