package com.foodapp.domain.usecases;

import com.foodapp.domain.models.Investor;
import com.foodapp.data.repositories.InvestorRepository;

public class GetInvestorProfitUseCase {
    private InvestorRepository repository;
    
    public GetInvestorProfitUseCase(InvestorRepository repository) {
        this.repository = repository;
    }
    
    public double execute(Investor investor) {
        return investor.getTotalProfit();
    }
}