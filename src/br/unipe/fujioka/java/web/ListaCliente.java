package br.unipe.fujioka.java.web;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidades.Cliente;

public class ListaCliente {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("cadastro");
		EntityManager manager = factory.createEntityManager();

		Query query = manager.createQuery("select c from Cliente c", Cliente.class);
		List<Cliente> lista = query.getResultList();

		for (Cliente c : lista)
			System.out.println(c);

		
		System.out.println("Lista com NamedQuery");
		List<Cliente> listaCliente = findAll(manager);
		for (Cliente c : listaCliente)
			System.out.println(c);
		
		
		System.out.println("Consulta com NamedQuery");
		Cliente cliente = findById(manager, 33l);
		System.out.println(cliente);
		
	

		
		manager.close();
		factory.close();

	}

	public static Cliente findById(EntityManager manager, Long id) {

		Query query = manager.createNamedQuery("cliente.findById");
		query.setParameter("id", id);
		Cliente c = (Cliente) query.getSingleResult();

		return c;
	}
	
	public static List<Cliente> findAll(EntityManager manager) {

		Query query = manager.createNamedQuery("cliente.findAll");		
		List<Cliente> lista = query.getResultList();

		return lista;
	}

}
