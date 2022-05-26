package br.com.unisep.controlepassagens.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class Estado {
	
	@NotNull(message = "Identificador não pode ser nulo")
	private int id;
	
	@NotNull(message = "Nome não pode ser nulo")
	@Length(max = 255, message = "Numero máximo de caracteres é 255")
	private String nome;
	
	@NotNull(message = "Sigla não pode ser nula")
	@Length(max = 2, message = "Numero máximo de caracteres é 2")
	private String sigla;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		
		this.sigla = sigla;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
