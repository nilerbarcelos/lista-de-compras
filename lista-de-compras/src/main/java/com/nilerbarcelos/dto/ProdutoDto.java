package com.nilerbarcelos.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProdutoDto {

	private int codigo;
	private String nome;
	private float valor;
	private int quantidade;

	public ProdutoDto() {

	}

	public ProdutoDto(int codigo, String nome, float valor, int quantidade) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.valor = valor;
		this.quantidade = quantidade;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}
