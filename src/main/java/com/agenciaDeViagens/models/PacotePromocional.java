package com.agenciaDeViagens.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pacotePromocional")
public class PacotePromocional {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	private int quantidade;
	private Double preco;
	
	@ManyToOne
	@JoinColumn(name = "destino_id", nullable = false)
	private Destino destino;


	
	public PacotePromocional(Destino destino, String Descricao ,int Quantidade, Double Preco) {
		super();
		this.descricao =Descricao;
		this.destino = destino;
	
		this.quantidade= Quantidade;
		this.preco = Preco;
	}

	public PacotePromocional() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Destino getDestino() {
		return destino;
	}

	public void setDestino(Destino destino) {
		this.destino = destino;
	}
	
	
	
	
}
