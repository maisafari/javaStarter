package io.altar.res.models;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ @NamedQuery(name = Product.GET_ALL_PRODUCTS, query = "SELECT p FROM Product p"),
		@NamedQuery(name = Product.GET_ALL_PRODUCTS_IDS, query = "SELECT p.id FROM Product p") })
public class Product extends Entity_ {

	public static final String GET_ALL_PRODUCTS = "getAllProducts";
	public static final String GET_ALL_PRODUCTS_IDS = "getAllProductsIds";

	private static final long serialVersionUID = 1L;
	private int discount;
	private int iva;
	private float pvp;

	public static String getName() {
		return "Product";
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getIva() {
		return iva;
	}

	public void setIva(int iva) {
		this.iva = iva;
	}

	public float getPvp() {
		return pvp;
	}

	public Product() {
		super();
	}

	public void setPvp(float pvp) {
		this.pvp = pvp;
	}

	@Override
	public String toString() {
		return "Product [discount=" + discount + ", iva=" + iva + ", pvp=" + pvp + "]";
	}

}
