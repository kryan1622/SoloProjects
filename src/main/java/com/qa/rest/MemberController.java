package com.qa.rest;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.MembersService;

@Path("/members")
public class MemberController {

	@Inject
	private MembersService service;
	
	@Path("/getAllMembers")
	@GET
	@Produces({"application/json"})
	public String getAllMembers() {
		return service.getAllMembers();
	}
	
	@Path("/findMember/{memberid}")
	@GET
	@Produces({"application/json"})
	public String findMember(@PathParam("memberid")int memberid) {
		return service.findMember(memberid);
	}
	
	@Path("/findMemberbyName/{firstname}")
	@GET
	@Produces({"application/json"})
	public String findMemberbyName(@PathParam("firstname")String firstname) {
		return service.findMemberbyName(firstname);
	}
	
	@Path("/deleteMember/{memberid}")
	@DELETE
	@Produces({"application/json"})
	public String deleteMember(@PathParam("memberid")int memberid) {
		return service.deleteMember(memberid);
	}
	
	@Path("/updateMember/{memberid}")
	@PUT
	@Produces({"application/json"})
	public String updateMember(@PathParam("memberid")int memberid, String member) {
		return service.updateMember(memberid, member);
	}
	
	@Path("/createMember")
	@POST
	@Produces({"application/json"})
	public String createMember(String member) {
		return service.createMember(member);
	}
}
