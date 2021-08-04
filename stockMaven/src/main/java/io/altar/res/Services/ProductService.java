package io.altar.res.Services;

import java.util.List;

import javax.enterprise.context.RequestScoped;

import io.altar.res.models.Product;
import io.altar.res.repositories.ProductRepository;

@RequestScoped
public class ProductService extends EntityService<ProductRepository, Product> {

	public boolean getIfProductExists(long id) {
		return repository.existId(id);
	}

	public Product getProductByProductID(long id) {
		if (getIfProductExists(id) == false) {
			return null;
		} else {
			return repository.getEntity(id);
		}
	}

	public List<Product> getAll() {
		return repository.getAll();
	}

	public void setPvp(long prodId, float pvp) {
		repository.setPvp(prodId, pvp);
	}

	public void setIva(long prodId, float iva) {
		repository.setIva(prodId, iva);

	}

	public void setDiscount(long prodId, float disc) {
		repository.setDiscount(prodId, disc);

	}

}
