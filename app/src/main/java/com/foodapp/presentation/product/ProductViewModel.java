package com.foodapp.presentation.product;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.foodapp.data.repositories.ProductRepository;
import com.foodapp.domain.models.Product;
import java.util.List;

public class ProductViewModel extends AndroidViewModel {
    private ProductRepository repository;
    
    private MutableLiveData<List<Product>> products = new MutableLiveData<>();
    private MutableLiveData<Product> selectedProduct = new MutableLiveData<>();
    
    public ProductViewModel(Application application) {
        super(application);
        repository = new ProductRepository(new AppDatabaseBuilder().build());
        loadProducts();
    }
    
    public void loadProducts() {
        List<Product> productList = repository.getAll();
        products.setValue(productList);
    }
    
    public void addProduct(Product product) {
        repository.insert(product);
        loadProducts();
    }
    
    public void updateProduct(Product product) {
        repository.update(product);
        loadProducts();
    }
    
    public void deleteProduct(long id) {
        repository.delete(id);
        loadProducts();
    }
    
    public LiveData<List<Product>> getProducts() { return products; }
    public LiveData<Product> getSelectedProduct() { return selectedProduct; }
    
    public void setSelectedProduct(Product product) {
        selectedProduct.setValue(product);
    }
}

class AppDatabaseBuilder {
    public static AppDatabase build() {
        // This is a simplified placeholder - in a real app, use Dependency Injection
        return Room.databaseBuilder(
            (FoodApp) android.app.ActivityThread.currentApplication(),
            AppDatabase.class,
            "foodapp_db"
        ).build();
    }
}