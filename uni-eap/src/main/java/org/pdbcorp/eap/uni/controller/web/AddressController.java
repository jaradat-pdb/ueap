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
package org.pdbcorp.eap.uni.controller.web;

import org.pdbcorp.eap.uni.service.details.impl.AddressDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author jaradat-pdb
 */
@Controller
@RequestMapping("/address")
public class AddressController {

	private AddressDetailsService addressDetailsService;

	@Autowired
	public AddressController(AddressDetailsService addressDetailsService) {
		this.addressDetailsService = addressDetailsService;
	}

	@GetMapping("/")
	public String getAddressControllerHome() {
		return "addressControllerHome";
	}

}
