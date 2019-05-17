package br.unipe.fujioka.java.web;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.Cliente;

public class GravaCliente {
	
	public static void main(String[] args) {
		
		Cliente cliente = new Cliente();
		cliente.setNome("Rousyane Melo");
		cliente.setDataFim(new Date());
		cliente.setDataInicio(new Date());
		//System.out.println(cliente);
		
		Cliente cliente2 = new Cliente();
		cliente2.setNome("Willma Tayanne");
		cliente2.setDataFim(new Date());
		cliente2.setDataInicio(new Date());
		//System.out.println(cliente2);
		
		Cliente cliente3 = new Cliente();
		cliente3.setNome("Marcio Barbosa");
		cliente3.setDataFim(new Date());
		cliente3.setDataInicio(new Date());
		//System.out.println(cliente3);
				
		ClienteDAO dao = ClienteDAO.getInstance();
		
		List<Cliente> lista = dao.findAll();
		
		for(Cliente c : lista) {
			dao.remove(c);
		}
		
		dao.persist(cliente);
		dao.persist(cliente2);
		dao.persist(cliente3);
		
		//System.out.println(dao.findAll());
		for (Cliente cliente4 : dao.findAll()) {
			System.out.println(cliente4);
		}
		
		cliente2.setNome("Gustavo Pundizinho");
		dao.merge(cliente2);
		
		dao.remove(cliente3);
		
		for (Cliente cliente4 : dao.findAll()) {
			System.out.println(cliente4);
		}
		
		System.exit(0);
			
	}

}
