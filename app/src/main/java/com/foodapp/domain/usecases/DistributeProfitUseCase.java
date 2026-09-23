package com.foodapp.domain.usecases;

import com.foodapp.domain.models.Investor;
import com.foodapp.data.repositories.InvestorRepository;

public class DistributeProfitUseCase {
    private InvestorRepository repository;
    
    public DistributeProfitUseCase(InvestorRepository repository) {
        this.repository = repository;
    }
    
    public void execute() {
        double totalProfit = 0;
        for (Investor investor : repository.getAll()) {
            totalProfit += investor.getInvestmentAmount() * (investor.getEquityPercentage() / 100.0);
        }
        
        for (Investor investor : repository.getAll()) {
            double investorProfit = totalProfit * (investor.getEquityPercentage() / 100.0);
            investor.setTotalProfit(investorProfit);
            repository.update(investor);
        }
    }
}