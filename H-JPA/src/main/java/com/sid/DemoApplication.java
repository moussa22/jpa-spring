package com.sid;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.sid.dao.EntityRepositoryDAO;
import com.sid.enties.Produit;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(DemoApplication.class, args);
		EntityRepositoryDAO<Produit> produitdao=ctx.getBean(EntityRepositoryDAO.class);
		
		produitdao.save(new Produit("LX450",8000,7));
		
		produitdao.save(new Produit("LX451",9000,8));
		    
		produitdao.save(new Produit("LX452",8000,9));
		
		List<Produit> produits=produitdao.findAll();
		
		for(Produit p:produits) {
			
			System.out.println("Designtion"+p.getDesignation());
			System.out.println("Prix"+p.getPrix());
			System.out.println("Quantite"+p.getQuantite());
			
		}
	}

}
