package repositories;

import io.altar.jseproject.model.Shelf;
// modelo singleton
public class ShelfRepository extends EntityRepository<Shelf>{
	
	private static ShelfRepository INSTANCE = new ShelfRepository();
	
	
	public ShelfRepository() {
		
		// TODO Auto-generated constructor stub
	}


	public static ShelfRepository getInstance() {
		
		return INSTANCE;
	}

	
	
	
	
}
