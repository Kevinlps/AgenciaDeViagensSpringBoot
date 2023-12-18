package com.agenciaDeViagens.service;

import java.util.List;


import com.agenciaDeViagens.models.Compra;

public interface CompraService {

	List<Compra> getAllCompra();
	
	Compra getCompraById(Long id);
	
	Compra saveCompra(Compra Compra);
	
	Compra updateCompra(Long id, Compra CompraAtualizada);
	
	void deleteCompra(Long id);
}
