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
package org.pdbcorp.eap.uni.data.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.neo4j.springframework.data.core.schema.Node;
import org.neo4j.springframework.data.core.schema.Property;
import org.neo4j.springframework.data.core.schema.Relationship;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author jaradat-pdb
 */
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Getter
@Node(primaryLabel = "DEPARTMENT")
@NoArgsConstructor
@RequiredArgsConstructor
@Setter
public class Department extends GeneratedValueIdEntity {

	@NonNull
	@Property(name = "NAME")
	private String name;

	@EqualsAndHashCode.Exclude
	@JsonIgnoreProperties("department")
	@Relationship(type = "CURRICULUM", direction = Relationship.Direction.OUTGOING)
	private Set<Subject> subjects = new HashSet<>();

	@EqualsAndHashCode.Exclude
	@JsonIgnoreProperties("departments")
	@NonNull
	@Relationship(type = "UNI_DEPARTMENT", direction = Relationship.Direction.OUTGOING )
	private University university;

	@Override
	public String toString() {
		final int maxLen = 10;
		StringBuilder builder = new StringBuilder();
		builder.append("Department [");
		if (this.getId() != null) {
			builder.append("id=");
			builder.append(this.getId());
		}
		if (name != null) {
			builder.append(", name=");
			builder.append(name);
		}
		if (subjects != null) {
			builder.append(", subjects=");
			builder.append(toString(subjects, maxLen));
		}
		if (university != null) {
			builder.append(", university=");
			builder.append(university);
		}
		builder.append("]");
		return builder.toString();
	}

	private String toString(Collection<?> collection, int maxLen) {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		int i = 0;
		for (Iterator<?> iterator = collection.iterator(); iterator.hasNext() && i < maxLen; i++) {
			if (i > 0)
				builder.append(", ");
			builder.append(iterator.next());
		}
		builder.append("]");
		return builder.toString();
	}

}
