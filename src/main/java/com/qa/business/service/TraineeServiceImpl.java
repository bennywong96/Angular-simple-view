package com.qa.business.service;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.qa.persistence.repository.TraineeRepository;

public class TraineeServiceImpl implements TraineeService {

	private static final Logger LOGGER = Logger.getLogger(TraineeService.class);

	@Inject
	private TraineeRepository repo;

	public String getAllTrainees() {
		LOGGER.info("In TraineeServiceImpl getAllTrainees ");
		return repo.getAllTrainees();
	}

	
	public String addTrainee(String trainee) {
		LOGGER.info("In TraineeServiceImpl createTrainee");
		return repo.createTrainee(trainee);
	}

	public String updateTrainee(Long id, String trainee) {
		LOGGER.info("In TraineeServiceImpl updateTrainee");
		return repo.updateTrainee(id, trainee);
	}

	
	public String deleteTrainee(Long id) {
		LOGGER.info("In TraineeServiceImpl deleteTrainee");
		return repo.deleteTrainee(id);

	}

	public void setRepo(TraineeRepository repo) {
		this.repo = repo;
	}
}
