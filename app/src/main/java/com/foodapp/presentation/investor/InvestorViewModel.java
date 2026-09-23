package com.foodapp.presentation.investor;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.foodapp.data.repositories.InvestorRepository;
import com.foodapp.domain.models.Investor;
import com.foodapp.domain.usecases.CalculateAnnualProfitUseCase;
import com.foodapp.domain.usecases.DistributeProfitUseCase;
import java.util.List;

public class InvestorViewModel extends AndroidViewModel {
    private InvestorRepository repository;
    private CalculateAnnualProfitUseCase calculateProfitUseCase;
    private DistributeProfitUseCase distributeProfitUseCase;
    
    private MutableLiveData<List<Investor>> investors = new MutableLiveData<>();
    private MutableLiveData<Double> annualProfit = new MutableLiveData<>();
    private MutableLiveData<Double> investorProfit = new MutableLiveData<>();
    
    public InvestorViewModel(Application application) {
        super(application);
        repository = new InvestorRepository(new AppDatabaseBuilder().build());
        calculateProfitUseCase = new CalculateAnnualProfitUseCase(repository);
        distributeProfitUseCase = new DistributeProfitUseCase(repository);
        loadInvestors();
    }
    
    public void loadInvestors() {
        List<Investor> investorList = repository.getAll();
        investors.setValue(investorList);
    }
    
    public void addInvestor(Investor investor) {
        repository.insert(investor);
        loadInvestors();
    }
    
    public void calculateAnnualProfit() {
        double profit = calculateProfitUseCase.execute();
        annualProfit.setValue(profit);
    }
    
    public void distributeAnnualProfit() {
        distributeProfitUseCase.execute();
        loadInvestors();
    }
    
    public LiveData<List<Investor>> getInvestors() { return investors; }
    public LiveData<Double> getAnnualProfit() { return annualProfit; }
    public LiveData<Double> getInvestorProfit() { return investorProfit; }
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