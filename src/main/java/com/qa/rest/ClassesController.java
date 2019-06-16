package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.ClassesService;

@Path("/classes")
public class ClassesController {
	
	@Inject
	private ClassesService service;
	
	@Path("/getAllClasses")
	@GET
	@Produces({"application/json"})
	public String getAllClasses() {
		return service.getAllClasses();
	}
	
	@Path("/findClass/{classid}")
	@GET
	@Produces({"application/json"})
	public String findClass(@PathParam("classid") int classid) {
		return service.findClass(classid);
	}
	
	@Path("/deleteClass/{classid}")
	@DELETE
	@Produces({"application/json"})
	public String deleteClass(@PathParam("classid")int classid) {
		return service.deleteClass(classid);
	}
	
	@Path("/updateClass/{classid}")
	@PUT
	@Produces({"application/json"})
	public String updateClass(@PathParam("classid")int classid, String Classes) {
		return service.updateClass(classid, Classes);
	}
	
	@Path("/createClass")
	@POST
	@Produces({"application/json"})
	public String createClass(String Classes) {
		return service.createClass(Classes);
	}

}
