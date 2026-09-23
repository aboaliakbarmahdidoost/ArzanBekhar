package com.foodapp.data.repositories;

import com.foodapp.data.database.AppDatabase;
import com.foodapp.domain.models.Product;
import java.util.List;

public class ProductRepository {
    private AppDatabase database;
    
    public ProductRepository(AppDatabase database) {
        this.database = database;
    }
    
    public void insert(Product product) {
        new Thread(() -> database.productDao().insert(product)).start();
    }
    
    public Product getById(long id) {
        return new Thread(() -> {
            try {
                return database.productDao().getById(id);
            } catch (Exception e) {
                return null;
            }
        }).run();
    }
    
    public List<Product> getByCategory(String category) {
        return new Thread(() -> {
            try {
                return database.productDao().getByCategory(category);
            } catch (Exception e) {
                return null;
            }
        }).run();
    }
    
    public List<Product> getAll() {
        return new Thread(() -> {
            try {
                return database.productDao().getAll();
            } catch (Exception e) {
                return null;
            }
        }).run();
    }
    
    public void update(Product product) {
        new Thread(() -> database.productDao().update(product)).start();
    }
    
    public void delete(long id) {
        new Thread(() -> database.productDao().delete(id)).start();
    }
}