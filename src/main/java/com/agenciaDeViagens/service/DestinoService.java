package com.agenciaDeViagens.service;

import java.util.List;


import com.agenciaDeViagens.models.Destino;

public interface DestinoService  {

	List<Destino> getAllDestino();
	
	Destino getDestinoById(Long id);
	
	Destino saveDestino(Destino Destino);
	
	Destino updateDestino(Long id, Destino DestinoAtualizado);
	
	void deleteDestino(Long id);
}
