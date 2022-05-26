package br.com.unisep.controlepassagens.shared;

public interface ValidatorGenerico<T> {
	
	ValidatorResponse validateInsert(T entity);
	
	ValidatorResponse validateUpdate(T entity);
	
	ValidatorResponse validateDelete(int id);

}
