package com.reto.meli.domain.dto;

import java.io.Serializable;

public class StatsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1171502170353088142L;
	
	private Double farthestDistance;
    private String farthestCountry;
    private Double closestDistance;
    private String closestCountry;
    private Double averageDistance;
    
	
	public StatsDTO() {
		
	}

	public StatsDTO(Double farthestDistance, String farthestCountry, Double closestDistance, String closestCountry,
			Double averageDistance) {
		super();
		this.farthestDistance = farthestDistance;
		this.farthestCountry = farthestCountry;
		this.closestDistance = closestDistance;
		this.closestCountry = closestCountry;
		this.averageDistance = averageDistance;
	}

	public Double getFarthestDistance() {
		return farthestDistance;
	}

	public void setFarthestDistance(Double farthestDistance) {
		this.farthestDistance = farthestDistance;
	}

	public String getFarthestCountry() {
		return farthestCountry;
	}

	public void setFarthestCountry(String farthestCountry) {
		this.farthestCountry = farthestCountry;
	}

	public Double getClosestDistance() {
		return closestDistance;
	}

	public void setClosestDistance(Double closestDistance) {
		this.closestDistance = closestDistance;
	}

	public String getClosestCountry() {
		return closestCountry;
	}

	public void setClosestCountry(String closestCountry) {
		this.closestCountry = closestCountry;
	}

	public Double getAverageDistance() {
		return averageDistance;
	}

	public void setAverageDistance(Double averageDistance) {
		this.averageDistance = averageDistance;
	}

}
