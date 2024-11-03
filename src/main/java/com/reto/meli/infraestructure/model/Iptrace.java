package com.reto.meli.infraestructure.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "iptrace")
public class Iptrace implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5696669453584868718L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "iptrace_id_seq")
	@SequenceGenerator(name = "iptrace_id_seq", sequenceName = "iptrace_id_seq", initialValue = 1, allocationSize = 1)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	private String pais;
	
	private Double distancia;
	
	private Integer invocaciones;
	
	public Iptrace() {

	}

	public Iptrace(Long id, String pais, Double distancia, Integer invocaciones) {
		super();
		this.id = id;
		this.pais = pais;
		this.distancia = distancia;
		this.invocaciones = invocaciones;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Double getDistancia() {
		return distancia;
	}

	public void setDistancia(Double distancia) {
		this.distancia = distancia;
	}

	public Integer getInvocaciones() {
		return invocaciones;
	}

	public void setInvocaciones(Integer invocaciones) {
		this.invocaciones = invocaciones;
	}

	@Override
	public String toString() {
		return "Iptrace [id=" + id + ", pais=" + pais + ", distancia=" + distancia + ", invocaciones=" + invocaciones
				+ "]";
	}
	
	

}
