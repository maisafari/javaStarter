package jeeexample.repositories;

import javax.enterprise.context.RequestScoped;

import jeeexample.models.User;

@RequestScoped
public class UserRepository extends EntityRepository<User> {

	@Override
	protected Class<User> getEntityClass() {
		return User.class;
	}

	@Override
	protected String getAllEntities() {
		return User.GET_ALL_USERS;
	}
	
	@Override
	protected String getAllEntitiesIds() {
		return User.GET_ALL_USERS_IDS;
	}
	
	@Override
	protected String getEntitiesCount() {
		return User.GET_USERS_COUNT;
	}
}
