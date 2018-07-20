package com.qa.persistence.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.qa.persistence.domain.Trainee;
import com.qa.persistence.domain.Subject;
import com.qa.util.JSONUtil;

@ApplicationScoped
@Alternative
public class TraineeMapRepository implements TraineeRepository {
	
	private static final Logger LOGGER = Logger.getLogger(TraineeRepository.class);

	private final Long INITIAL_COUNT = 1L;
	private Map<Long, Trainee> traineeMap;
	private Long ID;

	@Inject
	private JSONUtil util;

	public TraineeMapRepository() {
		this.traineeMap = new HashMap<Long, Trainee>();
		ID = INITIAL_COUNT;
		initTraineeMap();
	}

	public String getAllTrainees() {
		LOGGER.info("In TraineeMapRepoistory getAllTrainees ");
		return util.getJSONForObject(traineeMap.values());
	}

	public String createTrainee(String trainee) {
		LOGGER.info("In TraineeMapRepoistory createTrainee");
		ID++;
		Trainee newTrainee = util.getObjectForJSON(trainee, Trainee.class);
		newTrainee.setId(ID);
		traineeMap.put(newTrainee.getId(), newTrainee);
		return trainee;
	}

	public String updateTrainee(Long id, String traineeToUpdate) {
		LOGGER.info("In TraineeMapRepoistory updateTrainee");
		Trainee newTrainee = util.getObjectForJSON(traineeToUpdate, Trainee.class);
		newTrainee.setId(id);
		traineeMap.put(id, newTrainee);
		return traineeToUpdate;
	}

	public String deleteTrainee(Long id) {
		LOGGER.info("In TraineeMapRepoistory deleteTrainee");
		traineeMap.remove(id);
		return "{\"message\": \"accout sucessfully removed\"}";
	}

	private void initTraineeMap() {
		Subject transaction = new Subject("sample");
		transaction.setId(1L);
		List<Subject> transactions = new ArrayList<>();
		transactions.add(transaction);
		Trainee trainee = new Trainee("Joe", "Bloggs", "1234", transactions);
		traineeMap.put(1L, trainee);
	}

}
