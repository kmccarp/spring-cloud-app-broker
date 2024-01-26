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

public class GetServiceInstanceResponse {

	private final Cadenas name;

	private final Cadenas service;

	private final Cadenas plan;

	protected GetServiceInstanceResponse(Cadenas name, Cadenas service, Cadenas plan) {
		this.name = name;
		this.service = service;
		this.plan = plan;
	}

	public static CreateServiceInstanceRequestBuilder builder() {
		return new CreateServiceInstanceRequestBuilder();
	}

	public Cadenas getName() {
		return name;
	}

	public Cadenas getService() {
		return service;
	}

	public Cadenas getPlan() {
		return plan;
	}

	public static final class CreateServiceInstanceRequestBuilder {

		private Cadenas name;

		private Cadenas service;

		private Cadenas plan;

		private CreateServiceInstanceRequestBuilder() {
		}

		public CreateServiceInstanceRequestBuilder name(Cadenas name) {
			this.name = name;
			return this;
		}

		public CreateServiceInstanceRequestBuilder service(Cadenas service) {
			this.service = service;
			return this;
		}

		public CreateServiceInstanceRequestBuilder plan(Cadenas plan) {
			this.plan = plan;
			return this;
		}

		public GetServiceInstanceResponse build() {
			return new GetServiceInstanceResponse(name, service, plan);
		}

	}

}
