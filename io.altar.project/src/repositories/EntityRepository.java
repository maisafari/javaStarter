package repositories;

import java.util.Collection;
import java.util.LinkedHashMap;

import io.altar.jseproject.model.Entity;

abstract class EntityRepository<T extends Entity> {

	LinkedHashMap<Long, T> dataBase = new LinkedHashMap<Long, T>();

	// maior id presente na base de dados
	long maxId;

	// get next id
	private long returnNextId() {
		
		return ++maxId;
	}
	// criar entidades

	public long createEntity(T entidade) {
		entidade.setId(returnNextId());
		dataBase.put(entidade.getId(), entidade);
		return entidade.getId();

	}

	// consultar entidades
	public T getEntity(long id) {
		return dataBase.get(id);
		
	} 
	
	
	// editar entidades
	public void editEntity(T entidade) {
		
		dataBase.put(entidade.getId(), entidade);
	}
	
	// recebe id devolve a entity
	// n recebe valores e devolve todos
	
	public Collection<T> getAll() {
		return dataBase.values();
	}

	// remover entidades

	public void removeFromDataBase(long id) {
		dataBase.remove(id);
	}
	

	@Override
	public String toString() {
		return "EntityRepository [dataBase=" + dataBase + "]";
	}

}
