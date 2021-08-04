package io.altar.stockMaven.services;

import javax.enterprise.context.RequestScoped;

import io.altar.stockMaven.models.Product;
import io.altar.stockMaven.repositories.ProductRepository;

@RequestScoped
public class ProductService extends EntityService<ProductRepository, Product> {
	
}
