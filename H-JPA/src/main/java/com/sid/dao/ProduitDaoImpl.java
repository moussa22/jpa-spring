package com.sid.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.sid.enties.Produit;
@Repository
@Transactional
public class ProduitDaoImpl implements EntityRepositoryDAO<Produit>{
	@PersistenceContext
	private EntityManager em;

	@Override
	public Produit save(Produit p) {
		em.persist(p);
		return p;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Produit> findByDesignation(String mc) {
		Query query=em.createQuery("Select p from Produit p where p like:x");
		em.setProperty("x", mc);
		return query.getResultList();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Produit> findAll() {
		
		Query query=em.createQuery("Select p from Produit p");
		return query.getResultList();
		
	}

	@Override
	public Produit finfOne(Long id) {
		Produit p=em.find(Produit.class, id);
		return p;
	}

	@Override
	public Produit update(Produit p) {
		
		em.merge(p);
		
		return p;
	}

	@Override
	public void delete(Long id) {
		
		Produit p=em.find(Produit.class, id);
		
		em.remove(p);

		
	}

}
