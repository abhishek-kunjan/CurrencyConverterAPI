package com.example.currencyconverter.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.currencyconverter.model.ExchangeRateResponse;

@Service
public class ExchangeRatesService {

	private final String API_URL = "http://api.exchangeratesapi.io/v1/latest?access_key=d6e1a9b20762848dc35265c6a1e7eecd";
	private final RestTemplate restTemplate = new RestTemplate();

	public ExchangeRateResponse getExchangeRates() {
		try {
			ExchangeRateResponse response = restTemplate.getForObject(API_URL, ExchangeRateResponse.class);
			if (response == null || response.getRates() == null) {
				throw new RuntimeException("Failed to fetch exchange rates from API.");
			}
			return response;
		} catch (Exception e) {
			throw new RuntimeException("API error: " + e.getMessage());
		}
	}

	public double convertCurrency(String from, String to, double amount) {
		ExchangeRateResponse response = getExchangeRates();
		if (response.getRates().containsKey(from) && response.getRates().containsKey(to)) {
			double fromRate = response.getRates().get(from);
			double toRate = response.getRates().get(to);
			return (amount / fromRate) * toRate;
		}
		throw new IllegalArgumentException("Invalid currency code: " + from + " or " + to);
	}

}
