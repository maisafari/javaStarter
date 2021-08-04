package io.altar.res.Services;

import java.util.List;

import javax.enterprise.context.RequestScoped;

import io.altar.res.models.Shelf;
import io.altar.res.repositories.ShelfRepository;

@RequestScoped

public class ShelfService extends EntityService<ShelfRepository, Shelf> {

	public Shelf setShelf(Shelf shelf) {

		shelf.setCapacity(shelf.getCapacity());
		shelf.setDailyPrice(shelf.getDailyPrice());
		return shelf;
	}

	public List<Shelf> getShelvesByProduct(long prodId) {
		return repository.getShelvesByProduct(prodId);
	}

	public List<Shelf> getEmptyShelves() {
		return repository.getEmptyShelves();
	}

	public List<Shelf> getAllShelves() {
		return repository.getAllShelves();
	}

	public boolean getIfShelfExists(long id) {
		return repository.existsId(id);
	}

	public void setCapacity(long shelfId, float cap) {
		repository.setCapacity(shelfId, cap);

	}

	public void setDailyPrice(long shelfId, float dP) {
		repository.setDailyPrice(shelfId, dP);

	}

}
