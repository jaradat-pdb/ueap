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
package org.pdbcorp.eap.uni.data.repo;

import org.pdbcorp.eap.uni.data.model.Address;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;

/**
 * 
 * @author jaradat-pdb
 */
@Repository
public interface AddressRepository extends BaseEntityRepository<Address> {

	public Flux<Address> findByAddrLine1(@Param("addrLine1") String addrLine1);

	public Flux<Address> findByAddrLine1AndCityAndCountry(@Param("addrLine1") String addrLine1, @Param("city") String city, @Param("country") String country);

}
