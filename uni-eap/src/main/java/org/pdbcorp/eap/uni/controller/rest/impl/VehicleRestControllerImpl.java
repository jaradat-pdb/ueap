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
package org.pdbcorp.eap.uni.controller.rest.impl;

import javax.ws.rs.core.Response;

import org.pdbcorp.eap.uni.controller.rest.VehicleRestController;
import org.pdbcorp.eap.uni.data.model.Vehicle;
import org.pdbcorp.eap.uni.process.flow.AddEntityProcessFlow;
import org.pdbcorp.eap.uni.service.retrieve.impl.VehicleDetailsRetrieverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import reactor.core.publisher.Flux;

/**
 * 
 * @author jaradat-pdb
 */
@Controller
public class VehicleRestControllerImpl implements VehicleRestController {

	private VehicleDetailsRetrieverService vehicleDetailsRetrieverService;
	private AddEntityProcessFlow<Vehicle> addVehicleProcessFlow;

	@Autowired
	public VehicleRestControllerImpl(
			VehicleDetailsRetrieverService vehicleDetailsRetrieverService,
			@Qualifier("addVehicleProcessFlow") AddEntityProcessFlow<Vehicle> addVehicleProcessFlow) {
		
		this.vehicleDetailsRetrieverService = vehicleDetailsRetrieverService;
		this.addVehicleProcessFlow = addVehicleProcessFlow;
	}

	@Override
	public Flux<Vehicle> findAll() {
		return vehicleDetailsRetrieverService.findAll();
	}

	@Override
	public Response findByMakeAndModel(String make, String model) {
		return Response.ok(vehicleDetailsRetrieverService.findByMakeAndModel(make, model)).build();
	}

	@Override
	public Response saveVehicle(Vehicle vehicle) {
		return Response.ok(addVehicleProcessFlow.execute(vehicle)).build();
	}

}
