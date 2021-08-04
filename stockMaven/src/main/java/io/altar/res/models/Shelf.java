package io.altar.res.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ @NamedQuery(name = Shelf.GET_ALL_SHELVES, query = "SELECT s from Shelf s"),
		@NamedQuery(name = Shelf.GET_SHELF_BY_ID, query = "SELECT s.id FROM Shelf s"),
		@NamedQuery(name = Shelf.GET_EMPTY_SHELVES, query = "SELECT s.id FROM Shelf s WHERE s.product = null"),
		@NamedQuery(name = Shelf.GET_SHELVES_BY_PROD_ID, query = "SELECT s FROM Shelf s Where s.product.id = :prodId")

})
public class Shelf extends Entity_ {

	public static final String GET_ALL_SHELVES = "getAllShelves";
	public static final String GET_SHELF_BY_ID = "getShelfById";
	public static final String GET_EMPTY_SHELVES = "getEmptyShelves";
	public static final String GET_SHELVES_BY_PROD_ID = "getShelvesByProdId";
	
	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.EAGER)
	private Product product;
	private int capacity;
	private float dailyPrice;

	public static String getName() {
		return "Shelf";
	}

	public Product getProduct() {
		return product;
	}

	public Shelf() {
		super();
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public float getDailyPrice() {
		return dailyPrice;
	}

	public void setDailyPrice(float dailyPrice) {
		this.dailyPrice = dailyPrice;
	}

	@Override
	public String toString() {
		return "Shelf [product=" + product + ", capacity=" + capacity + ", dailyPrice=" + dailyPrice + "]";
	}

	public Shelf(Product product, int capacity, float dailyPrice) {
		super();
		this.product = product;
		this.capacity = capacity;
		this.dailyPrice = dailyPrice;
	}

}
