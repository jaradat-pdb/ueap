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
package org.pdbcorp.eap.uni.service.generate.impl;

import org.apache.commons.lang3.StringUtils;
import org.pdbcorp.eap.uni.data.model.Department;
import org.pdbcorp.eap.uni.service.generate.GenerateNodeUidService;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author jaradat-pdb
 */
@Slf4j
@Service
class DepartmentNodeUidGeneratorService implements GenerateNodeUidService<Department> {

	/**
	 * This method constructs a <i>unique identifying</i> {@link java.lang.String String} based on the properties
	 * of the <code>DEPARTMENT</code> node. This {@link java.lang.String String} will be used in comparing and
	 * determining if a <code>DEPARTMENT</code> node already exists in the datastore with all the same field
	 * properties (i.e. <code>name</code> and <code>university</code>). This method does not factor in relational
	 * properties (i.e. ignores <code>subjects</code> property).
	 * 
	 * @param department - the <code>DEPARTMENT</code> object to construct the unique ID for.
	 * @return String - the unique ID for the node based off of its properties.
	 */
	@Override
	public String generateNodeUid(Department department) {
		StringBuilder stringBuilder = new StringBuilder();
		if(log.isTraceEnabled()) {
			log.trace("Building propsUid for entity: {}", department);
		}
		
		if(!StringUtils.isBlank(department.getName())) {
			stringBuilder.append(department.getName())
					.append(", universityId: ").append(department.getUniversity().getId());
			if(log.isDebugEnabled()) {
				log.debug("Successfully constructed propsUid: {}", stringBuilder.toString());
			}
		}
		
		return stringBuilder.toString();
	}

}
