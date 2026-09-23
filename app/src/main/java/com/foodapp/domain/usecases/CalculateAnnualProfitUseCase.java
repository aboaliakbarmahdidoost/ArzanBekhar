package com.foodapp.domain.usecases;

import com.foodapp.domain.models.Investor;
import com.foodapp.data.repositories.InvestorRepository;

public class CalculateAnnualProfitUseCase {
    private InvestorRepository repository;
    
    public CalculateAnnualProfitUseCase(InvestorRepository repository) {
        this.repository = repository;
    }
    
    public double execute() {
        double totalProfit = 0;
        for (Investor investor : repository.getAll()) {
            totalProfit += investor.getInvestmentAmount() * (investor.getEquityPercentage() / 100.0);
        }
        return totalProfit;
    }
}