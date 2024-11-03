package com.reto.meli.domain.cache;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.reto.meli.infraestructure.model.Iptrace;

@Service
public class CacheMeli {

	public CacheMeli() {

	}
	
	private volatile List<Iptrace> ipTraceCache = new ArrayList<>();
    private final Object lock = new Object();

    public void updateCache(List<Iptrace> newData) {
        synchronized (lock) {
            this.ipTraceCache = new ArrayList<>(newData);
        }
    }

    public List<Iptrace> getCache() {
        synchronized (lock) {
            return new ArrayList<>(ipTraceCache);
        }
    }

}
