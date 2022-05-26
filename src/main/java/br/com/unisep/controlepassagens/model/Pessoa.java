package br.com.unisep.controlepassagens.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class Pessoa {
	
	@NotNull(message = "Nome não pode ser nulo")
	@Length(max = 255, message = "Numero máximo de caracteres é 255")
	private String nome;
	
	@NotNull(message = "Telefone não pode ser nulo")
	@Length(max = 20, message = "Numero máximo de caracteres é 20")
	private String telefone;
	
	private List<Endereco> listaEnderecos = new ArrayList<Endereco>();
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public List<Endereco> getListaEnderecos() {
		return listaEnderecos;
	}
	public void setListaEnderecos(List<Endereco> listaEnderecos) {
		this.listaEnderecos = listaEnderecos;
	}
}
