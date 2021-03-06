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
package org.pdbcorp.eap.uni;

import org.neo4j.springframework.data.repository.config.EnableReactiveNeo4jRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@EnableNeo4jRepositories(basePackages = "org.pdbcorp.eap.uni.data.repo")
@EnableReactiveNeo4jRepositories(basePackages = "org.pdbcorp.eap.uni.data.repo")
@EnableTransactionManagement
@EntityScan(basePackages = "org.pdbcorp.eap.uni.data.model")
@SpringBootApplication
public class UniEapApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniEapApplication.class, args);
	}

}
