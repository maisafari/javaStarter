package io.altar.res.repositories;

import java.util.List;

import javax.enterprise.context.RequestScoped;

import io.altar.res.models.Shelf;

@RequestScoped
public class ShelfRepository extends EntityRepository<Shelf> {

	@Override
	public Class<Shelf> getEntityClass() {
		// TODO Auto-generated method stub
		return Shelf.class;
	}

	protected String getAll() {
		return Shelf.GET_ALL_SHELVES;
	}

	protected String getAllShelvesId() {
		return Shelf.GET_SHELF_BY_ID;
	}

	public boolean existsId(long id) {
		String query = "SELECT COUNT(e) FROM Shelf e WHERE e.id =  " + id;
		Long count = (Long) entityManager.createQuery(query).getSingleResult();
		return ((count.equals(0L) ? false : true));

	}

	public List<Shelf> getShelvesByProduct(long id) {

		return entityManager.createNamedQuery(Shelf.GET_SHELVES_BY_PROD_ID, getEntityClass()).setParameter("prodId", id)
				.getResultList();

	}

	public List<Shelf> getEmptyShelves() {
		return entityManager.createNamedQuery(Shelf.GET_EMPTY_SHELVES, getEntityClass()).getResultList();
	}

	public List<Shelf> getAllShelves() {
		return entityManager.createNamedQuery(Shelf.GET_ALL_SHELVES, getEntityClass()).getResultList();
	}

	public void setCapacity(long ShelfId, float cap) {
		String query = "UPDATE Shelf s SET s.capacity = " + cap + "WHERE s.id = " + ShelfId;
		entityManager.createQuery(query).executeUpdate();

	}

	public void setDailyPrice(long ShelfId, float dP) {
		String query = "UPDATE Shelf s SET s.dailyPrice = " + dP + "WHERE s.id = " + ShelfId;
		entityManager.createQuery(query).executeUpdate();

	}

}
