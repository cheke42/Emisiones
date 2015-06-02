package com.mutual.util;

import java.util.ArrayList;

import com.mutual.modelo.Itinerario;
import com.mutual.modelo.Sistema;

public class CodigoAeropuerto {

	public static ArrayList<String> codigoAeropuerto = new ArrayList<String>();
	
	public static void cargarCodigoAeropuerto(){
		for ( Itinerario itinerario : Sistema.getSistema().getItinerarios()) {
			codigoAeropuerto.add(itinerario.getCodigoAeropuerto()+" "+itinerario.getNombreAeropuerto());
		}
	}
			
					
}