/*
 * Copyright 2020 PDB Corp.
 *
 * Proprietary Software built off of open-source software?
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.pdbcorp.eap.uni.service.retrieve.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.pdbcorp.eap.uni.data.model.Vehicle;
import org.pdbcorp.eap.uni.data.repo.VehicleRepository;
import org.pdbcorp.eap.uni.util.TestDataFactoryUtil;

import reactor.core.publisher.Mono;

/**
 * 
 * @author jaradat-pdb
 */
@ExtendWith(MockitoExtension.class)
class VehicleDetailsRetrieverServiceTest {

	@Mock
	private VehicleRepository repository;
	@Mock
	private Mono<Vehicle> mockMono;

	@InjectMocks
	private VehicleDetailsRetrieverService service = new VehicleDetailsRetrieverService(repository);

	@DisplayName("Successfully query VEHICLE nodes using MAKE and MODEL")
	@Test
	void validFindByMakeAndModelTest() throws Exception {
		Vehicle expected = TestDataFactoryUtil.generateVehicleInstance();
		when(repository.findByMakeAndModel(expected.getMake(), expected.getModel())).thenReturn(Arrays.asList(expected));
		Collection<Vehicle> result = service.findByMakeAndModel(expected.getMake(), expected.getModel());
		assertTrue(result.contains(expected));
	}

	@DisplayName("Successfully save a VEHICLE node via the details service")
	@Test
	void validSaveEntityTest() throws Exception {
		Vehicle expected = TestDataFactoryUtil.generateVehicleInstance();
		when(repository.save(any())).thenReturn(mockMono);
		assertEquals(expected, service.saveEntity(expected));
	}

}
