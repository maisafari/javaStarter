package io.altar.jseproject.model;

public class Shelf extends Entity{
	
	private int capacidade;
	private Long productId;
	private float precoDeAluguerD;

	
	public Shelf() {
		//super();
	}

	public Shelf getShelf() {
		return (this);
	}

	public int getShelCapacity() {
		return (this.capacidade);
	}

	public Long getProduct() {
		return (this.productId);
	}


	public void setShelCapacity(int capacidade) {
		this.capacidade = capacidade;
	}

	public void setProduct(long productId) {
		this.productId = productId;
	}

	public float getPrecoDeAluguerD() {
		return precoDeAluguerD;
	}

	public void setPrecoDeAluguerD(float precoDeAluguerD) {
		this.precoDeAluguerD = precoDeAluguerD;
	}

	@Override
	public String toString() {
		return "Shelf [capacidade=" + capacidade + ", productId=" + productId + ", precoDeAluguerD=" + precoDeAluguerD
				+ ", id=" + getId() + "]";
	}



}
