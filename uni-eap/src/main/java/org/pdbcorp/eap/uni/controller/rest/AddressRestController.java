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

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.pdbcorp.eap.uni.data.model.Address;
import org.pdbcorp.eap.uni.data.model.Person;
import org.pdbcorp.eap.uni.data.model.University;

/**
 * 
 * @author jaradat-pdb
 */
@Path("/address")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface AddressRestController {

	@GET
	@Path("/find")
	Collection<Address> findAll();

	@GET
	@Path("/find/{addrLine1}")
	Response findByAddrLine1(@PathParam("addrLine1") String addrLine1);

	@POST
	@Path("/save")
	Response saveAddress(Address address);

	@PATCH
	@Path("/update/{id}/person")
	Response updateWithPerson(@PathParam("id") String id, Person person);

	@PATCH
	@Path("/update/{id}/university")
	Response updateWithUniversity(@PathParam("id") String id, University university);

}
