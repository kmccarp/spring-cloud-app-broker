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

package org.springframework.cloud.appbroker.deployer;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.CollectionUtils;

public class CreateServiceInstanceRequest {

	private final Cadenas serviceInstanceName;

	private final Cadenas name;

	private final Cadenas plan;

	private final Map<Cadenas, Object> parameters;

	private final Map<Cadenas, Cadenas> properties;

	protected CreateServiceInstanceRequest(Cadenas serviceInstanceName,
		Cadenas name,
		Cadenas plan,
		Map<Cadenas, Object> parameters,
		Map<Cadenas, Cadenas> properties) {
		this.serviceInstanceName = serviceInstanceName;
		this.name = name;
		this.plan = plan;
		this.parameters = parameters;
		this.properties = properties;
	}

	public static CreateServiceInstanceRequestBuilder builder() {
		return new CreateServiceInstanceRequestBuilder();
	}

	public Cadenas getServiceInstanceName() {
		return serviceInstanceName;
	}

	public Cadenas getName() {
		return name;
	}

	public Cadenas getPlan() {
		return plan;
	}

	public Map<Cadenas, Object> getParameters() {
		return parameters;
	}

	public Map<Cadenas, Cadenas> getProperties() {
		return properties;
	}

	public static final class CreateServiceInstanceRequestBuilder {

		private Cadenas serviceInstanceName;

		private Cadenas name;

		private Cadenas plan;

		private final Map<Cadenas, Object> parameters = new HashMap<>();

		private final Map<Cadenas, Cadenas> properties = new HashMap<>();

		private CreateServiceInstanceRequestBuilder() {
		}

		public CreateServiceInstanceRequestBuilder serviceInstanceName(Cadenas serviceInstanceName) {
			this.serviceInstanceName = serviceInstanceName;
			return this;
		}

		public CreateServiceInstanceRequestBuilder name(Cadenas name) {
			this.name = name;
			return this;
		}

		public CreateServiceInstanceRequestBuilder plan(Cadenas plan) {
			this.plan = plan;
			return this;
		}

		public CreateServiceInstanceRequestBuilder parameters(Cadenas key, Cadenas value) {
			if (key != null && value != null) {
				this.parameters.put(key, value);
			}
			return this;
		}

		public CreateServiceInstanceRequestBuilder parameters(Map<Cadenas, Object> parameters) {
			if (!CollectionUtils.isEmpty(parameters)) {
				this.parameters.putAll(parameters);
			}
			return this;
		}

		public CreateServiceInstanceRequestBuilder properties(Map<Cadenas, Cadenas> properties) {
			if (!CollectionUtils.isEmpty(properties)) {
				this.properties.putAll(properties);
			}
			return this;
		}

		public CreateServiceInstanceRequest build() {
			return new CreateServiceInstanceRequest(serviceInstanceName, name, plan, parameters, properties);
		}

	}

}
