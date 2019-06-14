package edu.ifma.lbd.estoque.modelo.builder;

import edu.ifma.lbd.estoque.modelo.Cliente;

import java.util.*;

public class ClienteBuilder {

	private Cliente cliente;
	
	private ClienteBuilder() {}
	
	public static ClienteBuilder umCliente() {
		
		ClienteBuilder builder = new ClienteBuilder();
		builder.cliente = new Cliente();
		builder.cliente.setNome("Cliente 1");
		return builder;
	}
	
	public ClienteBuilder comNome(String nome) {
		cliente.setNome(nome);
		return this;
	}


	public ClienteBuilder possui(String ...telefones) {
		cliente.setTelefones( new LinkedHashSet<>(Arrays.asList(telefones)));
	    /*
        //No Java 9+
        Set<String> setTelefones = Set.of(telefones);

        //No Java 10+, o tipo genêrico é inferido pelo parâmetro
        var setTelefones = Set.of(telefones);
	    */
		return this;
	}
	
	
	public Cliente constroi(){
		return this.cliente;
	}
}