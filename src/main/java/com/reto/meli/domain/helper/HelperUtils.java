package com.reto.meli.domain.helper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class HelperUtils {
	
	private static final Double BUENOS_AIRES_LAT = -34.6037;
    private static final Double BUENOS_AIRES_LON = -58.3816;
    
    // Radio de la Tierra en kilómetros
    private static final Double EARTH_RADIUS = 6371.0;
	
	
	
	private static final Logger LOGGER = LogManager.getLogger(HelperUtils.class);
	
	
	
	public  String getCurrentTimeInZone(String timeZone) {
        try {
            // Crear ZoneId a partir del string de zona horaria
            ZoneId zone = ZoneId.of(timeZone);
            
            // Obtener la hora actual en esa zona
            ZonedDateTime currentTime = ZonedDateTime.now(zone);
            
            // Formatear la hora (24h format con zona horaria)
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
            return currentTime.format(formatter);
        } catch (Exception e) {
            throw new IllegalArgumentException("Zona horaria no válida: " + timeZone);
        }
    }

	public  double distanceToBuenosAires(Double lat, Double lon) {
        return calculateDistance(lat, lon, BUENOS_AIRES_LAT, BUENOS_AIRES_LON);
    }

	private double calculateDistance(Double lat1, Double lon1, Double lat2, Double lon2) {
        // Convertir grados a radianes
        Double lat1Rad = Math.toRadians(lat1);
        Double lon1Rad = Math.toRadians(lon1);
        Double lat2Rad = Math.toRadians(lat2);
        Double lon2Rad = Math.toRadians(lon2);
        
        // Diferencias en coordenadas
        Double dLat = lat2Rad - lat1Rad;
        Double dLon = lon2Rad - lon1Rad;
        
        // Fórmula del haversine
        Double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.cos(lat1Rad) * Math.cos(lat2Rad) *
                   Math.sin(dLon / 2) * Math.sin(dLon / 2);
        
        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        
        // Calcular la distancia
        return EARTH_RADIUS * c;
    }
	
	public String getCurrentTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
		  
		Date date = new Date();
		
		String strDate = dateFormat.format(date);
		
		return strDate;
	}

}
