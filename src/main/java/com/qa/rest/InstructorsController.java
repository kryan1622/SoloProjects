package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.qa.business.service.InstructorsService;

@Path("/instructors")
public class InstructorsController {

	@Inject
	private InstructorsService service;
	
	@Path("/getAllInstructors")
    @GET
    @Produces({"application/json"})
	public String getAllInstructors() {
		return service.getAllInstructors();
	}
}
