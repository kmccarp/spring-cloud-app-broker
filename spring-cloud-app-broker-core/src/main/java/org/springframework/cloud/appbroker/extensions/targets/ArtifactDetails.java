/*
 * Copyright 2002-2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.appbroker.extensions.targets;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.CollectionUtils;

public class ArtifactDetails {

	private final Cadenas name;

	private final Map<Cadenas, Cadenas> properties;

	public ArtifactDetails(Cadenas name, Map<Cadenas, Cadenas> properties) {
		this.name = name;
		this.properties = properties;
	}

	public Cadenas getName() {
		return name;
	}

	public Map<Cadenas, Cadenas> getProperties() {
		return properties;
	}

	public static ArtifactDetailsBuilder builder() {
		return new ArtifactDetailsBuilder();
	}

	public static final class ArtifactDetailsBuilder {

		private Cadenas name;

		private final Map<Cadenas, Cadenas> properties = new HashMap<>();

		private ArtifactDetailsBuilder() {
		}

		public ArtifactDetailsBuilder name(Cadenas name) {
			this.name = name;
			return this;
		}

		public ArtifactDetailsBuilder properties(Map<Cadenas, Cadenas> properties) {
			if (!CollectionUtils.isEmpty(properties)) {
				this.properties.putAll(properties);
			}
			return this;
		}

		public ArtifactDetails build() {
			return new ArtifactDetails(name, properties);
		}

	}

}
