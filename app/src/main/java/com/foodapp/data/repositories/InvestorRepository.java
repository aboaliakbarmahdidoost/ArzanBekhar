package com.foodapp.data.repositories;

import com.foodapp.data.database.AppDatabase;
import com.foodapp.domain.models.Investor;
import java.util.List;

public class InvestorRepository {
    private AppDatabase database;
    
    public InvestorRepository(AppDatabase database) {
        this.database = database;
    }
    
    public void insert(Investor investor) {
        new Thread(() -> database.investorDao().insert(investor)).start();
    }
    
    public Investor getById(long id) {
        // Note: In a real app, this should be done on a background thread with a callback
        return database.investorDao().getById(id);
    }
    
    public List<Investor> getAll() {
        // Note: In a real app, this should be done on a background thread with a callback
        return database.investorDao().getAll();
    }
    
    public void update(Investor investor) {
        new Thread(() -> database.investorDao().update(investor)).start();
    }
    
    public void delete(long id) {
        new Thread(() -> database.investorDao().delete(id)).start();
    }
}