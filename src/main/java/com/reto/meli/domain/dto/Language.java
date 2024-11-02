package com.reto.meli.domain.dto;

import java.io.Serializable;

public class Language implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5868393287956223282L;
	private String code;
    private String name;
    private String nativeName;

	public Language() {
		
	}

	public Language(String code, String name, String nativeName) {
		super();
		this.code = code;
		this.name = name;
		this.nativeName = nativeName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNativeName() {
		return nativeName;
	}

	public void setNativeName(String nativeName) {
		this.nativeName = nativeName;
	}
	
	
}
