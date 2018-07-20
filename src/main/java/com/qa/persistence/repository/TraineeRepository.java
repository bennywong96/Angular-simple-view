package com.qa.persistence.repository;

public interface TraineeRepository {

	String getAllTrainees();

	String createTrainee(String accout);

	String updateTrainee(Long id, String traineeToUpdate);

	String deleteTrainee(Long id);

}
