package br.com.unisep.controlepassagens.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class Cidade {
	
	private int id;
	
	@NotNull(message = "Nome não pode ser nulo")
	@Length(max = 255, message = "Numero máximo de caracteres é 255")
	private String nome;
	
	@NotNull(message = "Estado não pode ser nulo")
	private Estado estado;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
