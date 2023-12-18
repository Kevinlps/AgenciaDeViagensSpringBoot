package com.agenciaDeViagens.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agenciaDeViagens.models.Cliente;
import com.agenciaDeViagens.repositories.ClienteRepository;
import com.agenciaDeViagens.service.ClienteService;

import jakarta.transaction.Transactional;

@Service
public class ClienteServiceImpl  implements ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public List<Cliente> getAllClientes() {
		return clienteRepository.findAll();
		}
	@Override
	@Transactional
	public Cliente getClienteById(Long id) {
		return clienteRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Cliente saveCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	public Cliente updateCliente(Long id, Cliente ClienteAtualizado) {
		Cliente clienteExistente = clienteRepository.findById(id).orElse(null);
		if (clienteExistente != null) { 
			clienteExistente.setNome(ClienteAtualizado.getNome());
			clienteExistente.setEndereco(ClienteAtualizado.getEndereco());
			clienteExistente.setEmail(ClienteAtualizado.getEmail());
			clienteExistente.setIdade(ClienteAtualizado.getIdade());
			clienteExistente.setCpf(ClienteAtualizado.getCpf());
			clienteExistente.setSenha(ClienteAtualizado.getSenha());
			return clienteRepository.save(ClienteAtualizado);
		} else { 
			throw new RuntimeException("Cliente não encontrado(a).");
		}
	}

	@Override
	public void deleteCliente(Long id) {
		clienteRepository.deleteById(id);
	}
}
