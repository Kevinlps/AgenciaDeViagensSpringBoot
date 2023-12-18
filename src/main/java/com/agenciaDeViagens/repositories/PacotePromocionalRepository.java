package com.agenciaDeViagens.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agenciaDeViagens.models.Destino;
import com.agenciaDeViagens.models.PacotePromocional;

@Repository
public interface PacotePromocionalRepository extends JpaRepository<PacotePromocional,Long>{
	List<Destino> findByDestino_Id(Long destinoId);
}



