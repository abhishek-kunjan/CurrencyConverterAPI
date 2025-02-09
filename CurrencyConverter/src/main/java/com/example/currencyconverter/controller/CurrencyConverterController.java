package com.example.currencyconverter.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.currencyconverter.model.ExchangeRateResponse;
import com.example.currencyconverter.service.ExchangeRatesService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CurrencyConverterController {

	private final ExchangeRatesService exchangeRateService;

	public CurrencyConverterController(ExchangeRatesService exchangeRateService) {
		this.exchangeRateService = exchangeRateService;
	}

	@GetMapping("/rates")
	public ExchangeRateResponse getExchangeRates(@RequestParam(defaultValue = "USD") String base) {
		ExchangeRateResponse response = exchangeRateService.getExchangeRates();
		response.setBase(base);
		return response;
	}

	@PostMapping("/convert")
	public Map<String, Object> convertCurrency(@RequestBody Map<String, Object> request) {
		String from = (String) request.get("from");
		String to = (String) request.get("to");
		double amount = Double.parseDouble(request.get("amount").toString());

		double convertedAmount = exchangeRateService.convertCurrency(from, to, amount);

		return Map.of("from", from, "to", to, "amount", amount, "convertedAmount", convertedAmount);
	}

}
