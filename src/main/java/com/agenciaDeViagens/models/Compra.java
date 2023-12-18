package com.agenciaDeViagens.models;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="compra")
public class Compra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	@ManyToOne
	@JoinColumn(name = "pacotePromocional_id", nullable = false)
	private PacotePromocional pacotePromocional;
	@ManyToOne
	@JoinColumn(name = "cliente_id", nullable = false)
	private Cliente cliente ;	
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate data;
	
	public Compra(Long id, PacotePromocional pacotePromocional, Cliente cliente, LocalDate data) {
		super();
		this.id = id;
		this.pacotePromocional = pacotePromocional;
		this.cliente = cliente;
		this.data = data;
	}

	public Compra() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PacotePromocional getPacotePromocional() {
		return pacotePromocional;
	}

	public void setPacotePromocional(PacotePromocional pacotePromocional) {
		this.pacotePromocional = pacotePromocional;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
	
}
