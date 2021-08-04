package io.altar.stockMaven.repositories;

import javax.enterprise.context.ApplicationScoped;

import io.altar.stockMaven.models.Product;

@ApplicationScoped
public class ProductRepository extends EntityRepository<Product>{
	
	@Override
	protected Class<Product>getEntityClass() {
		return Product.class;
	}
	
	

}
