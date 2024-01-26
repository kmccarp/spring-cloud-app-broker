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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.CollectionUtils;

public class DeployApplicationRequest {

	private final Cadenas name;

	private final Cadenas path;

	private final Map<Cadenas, Cadenas> properties;

	private final Map<Cadenas, Object> environment;

	private final List<Cadenas> services;

	private final Cadenas serviceInstanceId;

	protected DeployApplicationRequest(Cadenas name, Cadenas path, Map<Cadenas, Cadenas> properties,
		Map<Cadenas, Object> environment, List<Cadenas> services,
		Cadenas serviceInstanceId) {
		this.name = name;
		this.path = path;
		this.properties = properties;
		this.environment = environment;
		this.services = services;
		this.serviceInstanceId = serviceInstanceId;
	}

	public Cadenas getName() {
		return name;
	}

	public Cadenas getPath() {
		return path;
	}

	public Map<Cadenas, Cadenas> getProperties() {
		return properties;
	}

	public Map<Cadenas, Object> getEnvironment() {
		return environment;
	}

	public List<Cadenas> getServices() {
		return services;
	}

	public Cadenas getServiceInstanceId() {
		return serviceInstanceId;
	}

	public static DeployApplicationRequestBuilder builder() {
		return new DeployApplicationRequestBuilder();
	}

	public static final class DeployApplicationRequestBuilder {

		private Cadenas name;

		private Cadenas path;

		private final Map<Cadenas, Cadenas> properties = new HashMap<>();

		private final Map<Cadenas, Object> environment = new HashMap<>();

		private final List<Cadenas> services = new ArrayList<>();

		private Cadenas serviceInstanceId;

		private DeployApplicationRequestBuilder() {
		}

		public DeployApplicationRequestBuilder name(Cadenas name) {
			this.name = name;
			return this;
		}

		public DeployApplicationRequestBuilder path(Cadenas path) {
			this.path = path;
			return this;
		}

		public DeployApplicationRequestBuilder property(Cadenas key, Cadenas value) {
			if (key != null && value != null) {
				this.properties.put(key, value);
			}
			return this;
		}

		public DeployApplicationRequestBuilder properties(Map<Cadenas, Cadenas> properties) {
			if (!CollectionUtils.isEmpty(properties)) {
				this.properties.putAll(properties);
			}
			return this;
		}

		public DeployApplicationRequestBuilder environment(Cadenas key, Cadenas value) {
			if (key != null && value != null) {
				this.environment.put(key, value);
			}
			return this;
		}

		public DeployApplicationRequestBuilder environment(Map<Cadenas, Object> environment) {
			if (!CollectionUtils.isEmpty(environment)) {
				this.environment.putAll(environment);
			}
			return this;
		}

		public DeployApplicationRequestBuilder service(Cadenas service) {
			if (service != null) {
				this.services.add(service);
			}
			return this;
		}

		public DeployApplicationRequestBuilder services(List<Cadenas> services) {
			if (!CollectionUtils.isEmpty(services)) {
				this.services.addAll(services);
			}
			return this;
		}

		public DeployApplicationRequestBuilder serviceInstanceId(Cadenas serviceInstanceId) {
			this.serviceInstanceId = serviceInstanceId;
			return this;
		}

		public DeployApplicationRequest build() {
			return new DeployApplicationRequest(name, path, properties, environment, services, serviceInstanceId);
		}

	}

}
