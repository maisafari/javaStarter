package io.altar.res.repositories;

import java.util.List;

import javax.enterprise.context.RequestScoped;

import io.altar.res.models.Product;

@RequestScoped
public class ProductRepository extends EntityRepository<Product> {

	@Override
	protected Class<Product> getEntityClass() {
		// TODO Auto-generated method stub
		return Product.class;
	}

	protected String getAllProductsIds() {
		return Product.GET_ALL_PRODUCTS_IDS;
	}

	public boolean existId(long id) {
		String query = "SELECT COUNT(e) FROM Product e WHERE e.id = " + id;
		Long count = (Long) entityManager.createQuery(query).getSingleResult();
		return ((count.equals(0L)) ? false : true);
	}

	public List<Product> getAll() {
		return entityManager.createNamedQuery(Product.GET_ALL_PRODUCTS, getEntityClass()).getResultList();
	}

	public void setPvp(long prodId, float pvp) {
		String query = "UPDATE Product p SET p.pvp = " + pvp + "WHERE p.id = " + prodId;
		entityManager.createQuery(query).executeUpdate();

	}

	public void setIva(long prodId, float iva) {
		String query = "UPDATE Product p SET p.iva = " + iva + "WHERE p.id = " + prodId;
		entityManager.createQuery(query).executeUpdate();

	}

	public void setDiscount(long prodId, float disc) {
		String query = "UPDATE Product p SET p.discount = " + disc + "WHERE p.id = " + prodId;
		entityManager.createQuery(query).executeUpdate();

	}
}
