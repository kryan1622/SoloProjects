package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
	
	@Path("/findInstructor/{instructorid}")
	@GET
	@Produces({"application/json"})
	public String findInstructor(@PathParam("instructorid")int instructorid) {
		return service.findInstructor(instructorid);
	}
	
	@Path("/deleteInstructor/{instructorid}")
	@DELETE
	@Produces({"application/json"})
	public String deleteInstructor(@PathParam("instructorid")int instructorid) {
		return service.deleteInstructor(instructorid);
	}
	
	@Path("/updateInstructor/{instructorid}")
	@PUT
	@Produces({"application/json"})
	public String updateMember(@PathParam("instructorid")int instructorid, String Instructors) {
		return service.updateInstructor(instructorid, Instructors);
	}
	
	@Path("/createInstructor")
	@POST
	@Produces({"application/json"})
	public String createInstructor(String Instructor) {
		return service.createInstructor(Instructor);
	}
	}


