package com.foodapp.presentation.user;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.foodapp.data.repositories.UserRepository;
import com.foodapp.domain.models.User;
import java.util.List;

public class UserViewModel extends AndroidViewModel {
    private UserRepository repository;
    
    private MutableLiveData<User> currentUser = new MutableLiveData<>();
    private MutableLiveData<List<User>> allUsers = new MutableLiveData<>();
    
    public UserViewModel(Application application) {
        super(application);
        repository = new UserRepository(new AppDatabaseBuilder().build());
    }
    
    public void createUser(User user) {
        repository.insert(user);
    }
    
    public void loginUser(String email, String password) {
        User user = repository.getByEmail(email);
        if (user != null && user.getPasswordHash().equals(password)) {
            currentUser.setValue(user);
        }
    }
    
    public LiveData<User> getCurrentUser() { return currentUser; }
    public LiveData<List<User>> getAllUsers() { return allUsers; }
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