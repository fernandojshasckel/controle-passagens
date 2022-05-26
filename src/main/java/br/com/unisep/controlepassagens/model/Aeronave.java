package br.com.unisep.controlepassagens.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class Aeronave {
	
	private int id;
	
	@NotNull(message = "Fabricante não pode ser nulo")
	@Length(max = 255, message = "Numero máximo de caracteres é 255")
	private String fabricante;
	
	@Max(value = 1000, message = "O número máximo de passageiros é 1000")
	@Min(value = 50, message = "O número minimo de passageros é 50")
	private int numMaxPassageiros;
	
	private boolean isOperando;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public int getNumMaxPassageiros() {
		return numMaxPassageiros;
	}
	public void setNumMaxPassageiros(int numMaxPassageiros) {
		this.numMaxPassageiros = numMaxPassageiros;
	}
	public boolean isOperando() {
		return isOperando;
	}
	public void setOperando(boolean isOperando) {
		this.isOperando = isOperando;
	}
}
