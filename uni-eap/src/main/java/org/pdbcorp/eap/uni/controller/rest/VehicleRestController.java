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
package org.pdbcorp.eap.uni.controller.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.pdbcorp.eap.uni.data.model.Vehicle;

import reactor.core.publisher.Flux;

/**
 * 
 * @author jaradat-pdb
 */
@Path("/vehicle")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface VehicleRestController {

	@GET
	@Path("/find")
	Flux<Vehicle> findAll();

	@GET
	@Path("/find/{make}/{model}")
	Response findByMakeAndModel(@PathParam("make") String make, @PathParam("model") String model);

	@POST
	@Path("/save")
	Response saveVehicle(Vehicle vehicle);

}
