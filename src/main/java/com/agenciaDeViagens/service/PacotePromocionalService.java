package com.agenciaDeViagens.service;

import java.util.List;


import com.agenciaDeViagens.models.PacotePromocional;

public interface PacotePromocionalService {

	List<PacotePromocional> getAllPacotePromocional();
	
	PacotePromocional getPacotePromocionalById(Long id);
	
	PacotePromocional savePacotePromocional(PacotePromocional PacotePromocional);
	
	PacotePromocional updatePacotePromocional(Long id, PacotePromocional PacotePromocionalAtualizado);
	
	void deletePacotePromocional(Long id);
}

