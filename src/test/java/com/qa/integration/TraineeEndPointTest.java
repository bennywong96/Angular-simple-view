package com.qa.integration;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.business.service.TraineeService;

@RunWith(MockitoJUnitRunner.class)
public class TraineeEndPointTest {

	private static final String MOCK_VALUE2 = "test_value_2";

	private static final String MOCK_VALUE = "test_value";

	@InjectMocks
	private TraineeEndPoint endpoint;

	@Mock
	private TraineeService service;

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void gettingAllTrainees() {
		Mockito.when(service.getAllTrainees()).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.getAllTrainees());
	}
	

	@Test
	public void testCreateTrainee() {
		Mockito.when(service.addTrainee(MOCK_VALUE2)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.addTrainee(MOCK_VALUE2));
		Mockito.verify(service).addTrainee(MOCK_VALUE2);
	}

	@Test
	public void testUpdateTrainee() {
		Mockito.when(service.updateTrainee(1L, MOCK_VALUE2)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.updateTrainee(1L, MOCK_VALUE2));
		Mockito.verify(service).updateTrainee(1L, MOCK_VALUE2);
	}

	@Test
	public void testDeleteTrainee() {
		Mockito.when(service.deleteTrainee(1L)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.deleteTrainee(1L));
		Mockito.verify(service).deleteTrainee(1L);
	}
	

}
