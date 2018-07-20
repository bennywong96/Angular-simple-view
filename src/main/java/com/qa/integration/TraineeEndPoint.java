package com.qa.integration;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.TraineeService;

@Path("/trainees")
public class TraineeEndPoint {

	@Inject
	private TraineeService service;

	@Path("/json")
	@GET
	@Produces({ "application/json" })
	public String getAllTrainees() {
		return service.getAllTrainees();
	}

	@Path("/json")
	@POST
	@Produces({ "application/json" })
	public String addTrainee(String trainee) {
		return service.addTrainee(trainee);
	}

	@Path("/json/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateTrainee(@PathParam("id") Long id, String trainee) {
		return service.updateTrainee(id, trainee);
	}

	@Path("/json/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteTrainee(@PathParam("id") Long id) {
		return service.deleteTrainee(id);

	}

	public void setService(TraineeService service) {
		this.service = service;
	}

}