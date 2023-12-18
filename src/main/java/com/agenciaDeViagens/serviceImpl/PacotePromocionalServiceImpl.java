package com.agenciaDeViagens.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agenciaDeViagens.models.PacotePromocional;
import com.agenciaDeViagens.repositories.PacotePromocionalRepository;

import com.agenciaDeViagens.service.PacotePromocionalService;

import jakarta.transaction.Transactional;
@Service
public class PacotePromocionalServiceImpl implements PacotePromocionalService {
	@Autowired
	private PacotePromocionalRepository pacotePromocionalRepository;

	@Override
	public List<PacotePromocional> getAllPacotePromocional() {
		return pacotePromocionalRepository.findAll();
		}
	@Override
	@Transactional
	public PacotePromocional getPacotePromocionalById(Long id) {
		return pacotePromocionalRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public PacotePromocional savePacotePromocional(PacotePromocional pacotePromocional) {
		return pacotePromocionalRepository.save(pacotePromocional);
	}

	@Override
	public PacotePromocional updatePacotePromocional(Long id, PacotePromocional PacotePromocionalAtualizado) {
		PacotePromocional pacotePromocionalExistente = pacotePromocionalRepository.findById(id).orElse(null);
		if (pacotePromocionalExistente != null) { 
			pacotePromocionalExistente.setDescricao(PacotePromocionalAtualizado.getDescricao());
			pacotePromocionalExistente.setDestino(PacotePromocionalAtualizado.getDestino());
			pacotePromocionalExistente.setPreco(PacotePromocionalAtualizado.getPreco());
			pacotePromocionalExistente.setQuantidade(PacotePromocionalAtualizado.getQuantidade());
			return pacotePromocionalRepository.save(PacotePromocionalAtualizado);
		} else { 
			throw new RuntimeException("Pacote Promocional não encontrado.");
		}
	}

	@Override
	public void deletePacotePromocional(Long id) {
		pacotePromocionalRepository.deleteById(id);
	}
}
