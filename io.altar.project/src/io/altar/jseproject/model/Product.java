package io.altar.jseproject.model;

import java.util.ArrayList;
import java.util.List;

public class Product extends Entity {

	

	private List<Long> shelvesId = new ArrayList<Long>();
	private double valorUnitDesconto;
	private double iVA;
	private double pVP;
	
	public Product(List<Long> shelvesId, double valorUnitDesconto, double iVA, double pVP) {
		super();
		this.shelvesId = shelvesId;
		this.valorUnitDesconto = valorUnitDesconto;
		this.iVA = iVA;
		this.pVP = pVP;
	}
	
	public Product() {
		// super();
	}

	public double getProductIva() {
		return (this.iVA);
	}

	public double getProductPvp() {
		return (this.pVP);
	}

	public void setProductIva(float iVA) {

		this.iVA = iVA;

	}

	public void setProductPvp(float pVP) {
		this.pVP = pVP;
	}

	public double getValorUnitDesconto() {
		return valorUnitDesconto;
	}

	public void setValorUnitDesconto(double valorUnitDesconto) {
		this.valorUnitDesconto = valorUnitDesconto;
	}

	public List<Long> getShelvesId() {
		return shelvesId;
	}

	@Override
	public String toString() {
		return "Product [shelvesId=" + shelvesId + ", valorUnitDesconto=" + valorUnitDesconto + ", iVA=" + iVA
				+ ", pVP=" + pVP + ", id=" + id + "]";
	}

}
