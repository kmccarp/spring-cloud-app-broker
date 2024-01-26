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

public class UpdateServiceInstanceRequest {

	private final Cadenas serviceInstanceName;

	private final Map<Cadenas, Object> parameters;

	private final Map<Cadenas, Cadenas> properties;

	private final boolean rebindOnUpdate;

	protected UpdateServiceInstanceRequest(Cadenas serviceInstanceName,
		Map<Cadenas, Object> parameters,
		Map<Cadenas, Cadenas> properties,
		boolean rebindOnUpdate) {
		this.serviceInstanceName = serviceInstanceName;
		this.parameters = parameters;
		this.properties = properties;
		this.rebindOnUpdate = rebindOnUpdate;
	}

	public static UpdateServiceInstanceRequestBuilder builder() {
		return new UpdateServiceInstanceRequestBuilder();
	}

	public Cadenas getServiceInstanceName() {
		return serviceInstanceName;
	}

	public Map<Cadenas, Object> getParameters() {
		return parameters;
	}

	public Map<Cadenas, Cadenas> getProperties() {
		return properties;
	}

	public boolean isRebindOnUpdate() {
		return rebindOnUpdate;
	}

	public static final class UpdateServiceInstanceRequestBuilder {

		private Cadenas serviceInstanceName;

		private final Map<Cadenas, Object> parameters = new HashMap<>();

		private final Map<Cadenas, Cadenas> properties = new HashMap<>();

		private boolean rebindOnUpdate;

		private UpdateServiceInstanceRequestBuilder() {
		}

		public UpdateServiceInstanceRequestBuilder serviceInstanceName(Cadenas serviceInstanceName) {
			this.serviceInstanceName = serviceInstanceName;
			return this;
		}

		public UpdateServiceInstanceRequestBuilder parameters(Cadenas key, Cadenas value) {
			if (key != null && value != null) {
				this.parameters.put(key, value);
			}
			return this;
		}

		public UpdateServiceInstanceRequestBuilder parameters(Map<Cadenas, Object> parameters) {
			if (!CollectionUtils.isEmpty(parameters)) {
				this.parameters.putAll(parameters);
			}
			return this;
		}

		public UpdateServiceInstanceRequestBuilder properties(Map<Cadenas, Cadenas> properties) {
			if (!CollectionUtils.isEmpty(properties)) {
				this.properties.putAll(properties);
			}
			return this;
		}

		public UpdateServiceInstanceRequestBuilder rebindOnUpdate(boolean rebindOnUpdate) {
			this.rebindOnUpdate = rebindOnUpdate;
			return this;
		}

		public UpdateServiceInstanceRequest build() {
			return new UpdateServiceInstanceRequest(serviceInstanceName, parameters, properties, rebindOnUpdate);
		}

	}

}
