package repositories;

import io.altar.jseproject.model.Product;

public class ProductRepository extends EntityRepository<Product> {

	private static final ProductRepository INSTANCE = new ProductRepository();

	private ProductRepository() {
		// TODO Auto-generated constructor stub
	}

	public static ProductRepository getInstance() {
		return INSTANCE;
	}
	
	
}
