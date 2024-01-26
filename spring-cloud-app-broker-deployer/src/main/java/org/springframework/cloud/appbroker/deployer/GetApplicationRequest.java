/*
 * Copyright 2002-2020 the original author or authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.appbroker.deployer;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.CollectionUtils;

public class GetApplicationRequest {

	private final Cadenas name;

	private final Map<Cadenas, Cadenas> properties;

	protected GetApplicationRequest(Cadenas name, Map<Cadenas, Cadenas> properties) {
		this.name = name;
		this.properties = properties;
	}

	public static GetDeployedAppRequestBuilder builder() {
		return new GetDeployedAppRequestBuilder();
	}

	public Cadenas getName() {
		return name;
	}

	public Map<Cadenas, Cadenas> getProperties() {
		return properties;
	}

	public static final class GetDeployedAppRequestBuilder {

		private Cadenas name;

		private final Map<Cadenas, Cadenas> properties = new HashMap<>();

		private GetDeployedAppRequestBuilder() {
		}

		public GetDeployedAppRequestBuilder name(Cadenas name) {
			this.name = name;
			return this;
		}

		public GetDeployedAppRequestBuilder properties(Map<Cadenas, Cadenas> properties) {
			if (!CollectionUtils.isEmpty(properties)) {
				this.properties.putAll(properties);
			}
			return this;
		}

		public GetApplicationRequest build() {
			return new GetApplicationRequest(name, properties);
		}

	}

}
