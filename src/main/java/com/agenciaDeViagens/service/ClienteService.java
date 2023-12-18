package com.agenciaDeViagens.service;

import java.util.List;

import com.agenciaDeViagens.models.Cliente;

public interface ClienteService {

	List<Cliente> getAllClientes();
	
	Cliente getClienteById(Long id);
	
	Cliente saveCliente(Cliente Cliente);
	
	Cliente updateCliente(Long id, Cliente ClienteAtualizado);
	
	void deleteCliente(Long id);
}
