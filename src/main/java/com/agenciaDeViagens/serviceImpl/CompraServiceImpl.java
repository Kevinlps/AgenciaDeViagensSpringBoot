package com.agenciaDeViagens.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.agenciaDeViagens.models.Compra;
import com.agenciaDeViagens.repositories.CompraRepository;
import com.agenciaDeViagens.service.CompraService;

import jakarta.transaction.Transactional;
@Service
public class CompraServiceImpl implements CompraService {
	@Autowired
	private CompraRepository compraRepository;

	@Override
	public List<Compra> getAllCompra() {
		return compraRepository.findAll();
		}
	@Override
	@Transactional
	public Compra getCompraById(Long id) {
		return compraRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Compra saveCompra(Compra compra) {
		return compraRepository.save(compra);
	}

	@Override
	public Compra updateCompra(Long id, Compra CompraAtualizada) {
		Compra compraExistente = compraRepository.findById(id).orElse(null);
		if (compraExistente != null) { 
			compraExistente.setCliente(CompraAtualizada.getCliente());
			compraExistente.setData(CompraAtualizada.getData());
			compraExistente.setPacotePromocional(CompraAtualizada.getPacotePromocional());
			return compraRepository.save(CompraAtualizada);
		} else { 
			throw new RuntimeException("Compra não encontrada.");
		}
	}

	@Override
	public void deleteCompra(Long id) {
		compraRepository.deleteById(id);
	}
}
