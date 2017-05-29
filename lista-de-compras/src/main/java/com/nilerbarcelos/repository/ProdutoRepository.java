package com.nilerbarcelos.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.nilerbarcelos.model.ProdutoModel;

public class ProdutoRepository {

	private final EntityManagerFactory entityManagerFactory;

	private final EntityManager entityManager;

	public ProdutoRepository() {
		this.entityManagerFactory = Persistence.createEntityManagerFactory("persistence_unit_lista_de_compras");
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}

	public void salvar(ProdutoModel produtoModel) {
		this.entityManager.getTransaction().begin();
		this.entityManager.persist(produtoModel);
		this.entityManager.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List<ProdutoModel> buscaTodosProdutos() {
		return this.entityManager.createQuery("SELECT p FROM ProdutoModel p ORDER BY p.codigo").getResultList();
	}
}