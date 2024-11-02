package com.reto.meli.domain.dto;

public class CurrencyData {
	
	private String result;
	
	private String conversion_rate;


	public CurrencyData() {

	}


	public CurrencyData(String result, String conversion_rate) {
		super();
		this.result = result;
		this.conversion_rate = conversion_rate;
	}


	public String getResult() {
		return result;
	}


	public void setResult(String result) {
		this.result = result;
	}


	public String getConversion_rate() {
		return conversion_rate;
	}


	public void setConversion_rate(String conversion_rate) {
		this.conversion_rate = conversion_rate;
	}
	
	

}
