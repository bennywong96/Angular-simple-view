package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.qa.persistence.domain.Trainee;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class TraineeDBRepository implements TraineeRepository {
	
	private static final Logger LOGGER = Logger.getLogger(TraineeRepository.class);
	
	Trainee traineeInDB;
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;
	
	public String getAllTrainees() {
		LOGGER.info("In TraineeDBRepoistory getAllTrainees ");
		Query query = manager.createQuery("Select t FROM Trainee t");
		Collection<Trainee> trainees = (Collection<Trainee>) query.getResultList();
		return util.getJSONForObject(trainees); 
	}

	@Transactional(REQUIRED)
	public String createTrainee(String accout) {
		LOGGER.info("In TraineeDBRepoistory createTrainee");
		Trainee anTrainee = util.getObjectForJSON(accout, Trainee.class);
		manager.persist(anTrainee);
		return "{\"message\": \"trainee has been sucessfully added\"}";
	}

	@Transactional(REQUIRED)
	public String updateTrainee(Long id, String traineeToUpdate) {
		LOGGER.info("In TraineeDBRepoistory updateTrainee");
		Trainee updatedTrainee = util.getObjectForJSON(traineeToUpdate, Trainee.class);
		Trainee traineeFromDB = findTrainee(id);
		if (traineeToUpdate != null) {
			LOGGER.info("updateTrainee is not null");
			traineeFromDB = updatedTrainee;
			traineeFromDB.setId(id);
			manager.merge(traineeFromDB);
			return "{\"message\": \"trainee sucessfully updated\"}";
		}
		else {
			LOGGER.warn("updateTrainee is null");
			return "{\"message\": \"Error has occurred\"}";
		}
	}

	@Transactional(REQUIRED)
	public String deleteTrainee(Long id) {
		LOGGER.info("In TraineeDBRepoistory deleteTrainee");
		Trainee traineeInDB = findTrainee(id);
		if (traineeInDB != null) {
			LOGGER.info("deleteTrainee is not null");
			manager.remove(traineeInDB);
			return "{\"message\": \"trainee sucessfully deleted\"}";
		}
		else {
			LOGGER.warn("deleteTrainee is null");
			return "{\"message\": \"Error has occurred\"}";
		}
	}

	private Trainee findTrainee(Long id) {
		LOGGER.info("In TraineeDBRepoistory findTrainee");
		return manager.find(Trainee.class, id);
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}