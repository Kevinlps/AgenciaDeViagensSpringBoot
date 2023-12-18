package com.agenciaDeViagens.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agenciaDeViagens.models.Destino;
import com.agenciaDeViagens.repositories.DestinoRepository;

import com.agenciaDeViagens.service.DestinoService;

import jakarta.transaction.Transactional;
@Service
public class DestinoServiceImpl implements DestinoService {
	@Autowired
	private DestinoRepository destinoRepository;

	@Override
	public List<Destino> getAllDestino() {
		return destinoRepository.findAll();
		}
	@Override
	@Transactional
	public Destino getDestinoById(Long id) {
		return destinoRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Destino saveDestino(Destino destino) {
		return destinoRepository.save(destino);
	}

	@Override
	public Destino updateDestino(Long id, Destino DestinoAtualizado) {
		Destino destinoExistente = destinoRepository.findById(id).orElse(null);
		if (destinoExistente != null) { 
			destinoExistente.setEndereco(DestinoAtualizado.getEndereco());
			destinoExistente.setNome(DestinoAtualizado.getNome());
			destinoExistente.setQuantidade(DestinoAtualizado.getQuantidade());
			destinoExistente.setTelefone(DestinoAtualizado.getTelefone());
			return destinoRepository.save(DestinoAtualizado);
		} else { 
			throw new RuntimeException("Destino não encontrado.");
		}
	}

	@Override
	public void deleteDestino(Long id) {
		destinoRepository.deleteById(id);
	}
}
