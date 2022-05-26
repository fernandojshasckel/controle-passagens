package br.com.unisep.controlepassagens.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class Passagem {
	
	private int id;
	
	@NotNull(message = "Origem não pode ser nulo")
	private Cidade origem;
	
	@NotNull(message = "Destino não pode ser nulo")
	private Cidade destino;
	
	@NotNull(message = "Cliente não pode ser nulo")
	private Cliente cliente;
	
	private Aeronave aeronave;
	
	@NotNull(message = "Assento não pode ser nulo")
	@Length(max = 20, min = 5, message = "Numero minimo 5 e numero máximo de caracteres é 20")
	private String numAssento;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Cidade getOrigem() {
		return origem;
	}
	public void setOrigem(Cidade origem) {
		this.origem = origem;
	}
	public Cidade getDestino() {
		return destino;
	}
	public void setDestino(Cidade destino) {
		this.destino = destino;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Aeronave getAeronave() {
		return aeronave;
	}
	public void setAeronave(Aeronave aeronave) {
		this.aeronave = aeronave;
	}
	public String getNumAssento() {
		return numAssento;
	}
	public void setNumAssento(String numAssento) {
		this.numAssento = numAssento;
	}
}
