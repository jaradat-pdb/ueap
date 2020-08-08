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

import java.util.Collection;

import javax.ws.rs.core.Response;

import org.pdbcorp.eap.uni.controller.rest.DepartmentRestController;
import org.pdbcorp.eap.uni.data.model.Department;
import org.pdbcorp.eap.uni.service.impl.DepartmentDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 
 * @author jaradat-pdb
 */
@Controller
public class DepartmentRestControllerImpl implements DepartmentRestController {

	private DepartmentDetailsService departmentDetailsService;

	@Autowired
	public DepartmentRestControllerImpl(DepartmentDetailsService departmentDetailsService) {
		this.departmentDetailsService = departmentDetailsService;
	}

	@Override
	public Collection<Department> findAll() {
		return departmentDetailsService.findAll();
	}

	@Override
	public Response findByName(String name) {
		return Response.ok(departmentDetailsService.findByName(name)).build();
	}

	@Override
	public Response saveDepartment(Department department) {
		return Response.ok(departmentDetailsService.saveDepartment(department)).build();
	}

}