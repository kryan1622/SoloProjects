package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
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

}
