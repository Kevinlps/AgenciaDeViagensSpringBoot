package com.agenciaDeViagens.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agenciaDeViagens.models.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra,Long> {

}



