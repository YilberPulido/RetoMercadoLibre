package com.reto.meli.domain.dto;

public class IpLocationData {
	
	private String ip;
    private String type;
    private String continent_code;
    private String continent_name;
    private String country_code;
    private String country_name;
    private String region_code;
    private String region_name;
    private String city;
    private String zip;
    private Double latitude;
    private Double longitude;
    private String msa;
    private String dma;
    private String radius;
    private String ip_routing_type;
    private String connection_type;
    private Location location;
    private Boolean success;

	public IpLocationData() {

	}

	public IpLocationData(String ip, String type, String continent_code, String continent_name, String country_code,
			String country_name, String region_code, String region_name, String city, String zip, Double latitude,
			Double longitude, String msa, String dma, String radius, String ip_routing_type, String connection_type,
			Location location, Boolean success) {
		super();
		this.ip = ip;
		this.type = type;
		this.continent_code = continent_code;
		this.continent_name = continent_name;
		this.country_code = country_code;
		this.country_name = country_name;
		this.region_code = region_code;
		this.region_name = region_name;
		this.city = city;
		this.zip = zip;
		this.latitude = latitude;
		this.longitude = longitude;
		this.msa = msa;
		this.dma = dma;
		this.radius = radius;
		this.ip_routing_type = ip_routing_type;
		this.connection_type = connection_type;
		this.location = location;
		this.success = success;
	}


	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContinent_code() {
		return continent_code;
	}

	public void setContinent_code(String continent_code) {
		this.continent_code = continent_code;
	}

	public String getContinent_name() {
		return continent_name;
	}

	public void setContinent_name(String continent_name) {
		this.continent_name = continent_name;
	}

	public String getCountry_code() {
		return country_code;
	}

	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	public String getRegion_code() {
		return region_code;
	}

	public void setRegion_code(String region_code) {
		this.region_code = region_code;
	}

	public String getRegion_name() {
		return region_name;
	}

	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getMsa() {
		return msa;
	}

	public void setMsa(String msa) {
		this.msa = msa;
	}

	public String getDma() {
		return dma;
	}

	public void setDma(String dma) {
		this.dma = dma;
	}

	public String getRadius() {
		return radius;
	}

	public void setRadius(String radius) {
		this.radius = radius;
	}

	public String getIp_routing_type() {
		return ip_routing_type;
	}

	public void setIp_routing_type(String ip_routing_type) {
		this.ip_routing_type = ip_routing_type;
	}

	public String getConnection_type() {
		return connection_type;
	}

	public void setConnection_type(String connection_type) {
		this.connection_type = connection_type;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}


}
