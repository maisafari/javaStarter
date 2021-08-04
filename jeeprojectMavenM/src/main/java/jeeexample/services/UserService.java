package jeeexample.services;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import jeeexample.models.User;
import jeeexample.repositories.UserRepository;


@RequestScoped
@Path("api/user")
public class UserService extends EntityService<UserRepository, User> {
	
	@Inject
	protected UserRepository DBP;
	 
	@POST
	@Path ("fullName")
	@Consumes (MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User fullName(User user) {
		user.setName(user.getName());
		return DBP.addEntity(user);
	}
	
	
	
}
