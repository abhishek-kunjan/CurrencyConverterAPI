package com.example.currencyconverter.model;

import java.util.Map;

public class ExchangeRateResponse {
	private String base;
	private Map<String, Double> rates;

	private String error; 

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public Map<String, Double> getRates() {
		return rates;
	}

	public void setRates(Map<String, Double> rates) {
		this.rates = rates;
	}

	@Override
	public String toString() {
		return "ExchangeRateResponse [base=" + base + ", rates=" + rates + "]";
	}

}
