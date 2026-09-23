package com.foodapp.domain.models;

import java.util.UUID;

public class Investor {
    private UUID id;
    private String name;
    private String email;
    private double investmentAmount;
    private double equityPercentage;
    private double totalProfit;
    
    public Investor() {}
    
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public double getInvestmentAmount() { return investmentAmount; }
    public void setInvestmentAmount(double investmentAmount) { this.investmentAmount = investmentAmount; }
    
    public double getEquityPercentage() { return equityPercentage; }
    public void setEquityPercentage(double equityPercentage) { this.equityPercentage = equityPercentage; }
    
    public double getTotalProfit() { return totalProfit; }
    public void setTotalProfit(double totalProfit) { this.totalProfit = totalProfit; }
}