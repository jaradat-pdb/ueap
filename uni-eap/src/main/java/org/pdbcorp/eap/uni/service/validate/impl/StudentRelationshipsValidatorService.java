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
package org.pdbcorp.eap.uni.service.validate.impl;

import org.pdbcorp.eap.uni.data.model.Person;
import org.pdbcorp.eap.uni.data.model.Student;
import org.pdbcorp.eap.uni.service.generate.GenerateNodeUidService;
import org.pdbcorp.eap.uni.service.validate.ValidateEntityRelationshipsService;
import org.pdbcorp.eap.uni.service.validate.ValidateNodeUidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author jaradat-pdb
 */
@Slf4j
@Service
class StudentRelationshipsValidatorService implements ValidateEntityRelationshipsService<Student> {

	private GenerateNodeUidService<Person> personNodeUidGeneratorService;
	private ValidateNodeUidService<Person> personNodeUidValidatorService;

	@Autowired
	StudentRelationshipsValidatorService(
			@Qualifier("personNodeUidGeneratorService") GenerateNodeUidService<Person> personNodeUidGeneratorService,
			@Qualifier("personNodeUidValidatorService") ValidateNodeUidService<Person> personNodeUidValidatorService) {
		
		this.personNodeUidGeneratorService = personNodeUidGeneratorService;
		this.personNodeUidValidatorService = personNodeUidValidatorService;
	}

	@Override
	public Student validateEntityRelationships(Student student) {
		if(student.getPerson() != null) {
			if(log.isTraceEnabled()) {
				log.trace("Updating entity: {}", student);
			}
			student.getPerson().setNodeUid(personNodeUidGeneratorService.generateNodeUid(student.getPerson()));
			student.setPerson(personNodeUidValidatorService.validateNodeUid(student.getPerson()));
			if(log.isDebugEnabled()) {
				log.debug("Updated entity: {}", student);
			}
		}
		
		return student;
	}

}
