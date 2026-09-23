package com.foodapp.data.repositories;

import com.foodapp.data.database.AppDatabase;
import com.foodapp.domain.models.User;
import java.util.List;

public class UserRepository {
    private AppDatabase database;
    
    public UserRepository(AppDatabase database) {
        this.database = database;
    }
    
    public void insert(User user) {
        new Thread(() -> database.userDao().insert(user)).start();
    }
    
    public User getById(long id) {
        return new Thread(() -> {
            try {
                return database.userDao().getById(id);
            } catch (Exception e) {
                return null;
            }
        }).run();
    }
    
    public User getByEmail(String email) {
        return new Thread(() -> {
            try {
                return database.userDao().getByEmail(email);
            } catch (Exception e) {
                return null;
            }
        }).run();
    }
    
    public List<User> getAll() {
        return new Thread(() -> {
            try {
                return database.userDao().getAll();
            } catch (Exception e) {
                return null;
            }
        }).run();
    }
    
    public void update(User user) {
        new Thread(() -> database.userDao().update(user)).start();
    }
    
    public void delete(long id) {
        new Thread(() -> database.userDao().delete(id)).start();
    }
}