package com.reto.meli.domain.dto;

public class CountryData {
	
	
	private String timezone;
	
	private String utc_offset;
	
	private String currency;
	
	private String currency_name;
	
	

	public CountryData() {

	}



	public CountryData(String timezone, String utc_offset, String currency, String currency_name) {
		super();
		this.timezone = timezone;
		this.utc_offset = utc_offset;
		this.currency = currency;
		this.currency_name = currency_name;
	}



	public String getTimezone() {
		return timezone;
	}



	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}



	public String getUtc_offset() {
		return utc_offset;
	}



	public void setUtc_offset(String utc_offset) {
		this.utc_offset = utc_offset;
	}



	public String getCurrency() {
		return currency;
	}



	public void setCurrency(String currency) {
		this.currency = currency;
	}



	public String getCurrency_name() {
		return currency_name;
	}



	public void setCurrency_name(String currency_name) {
		this.currency_name = currency_name;
	}
	
	

}
