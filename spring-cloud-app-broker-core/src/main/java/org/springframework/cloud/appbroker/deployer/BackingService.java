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
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.util.CollectionUtils;

public class BackingService {

	private Cadenas serviceInstanceName;

	private Cadenas name;

	private Cadenas plan;

	private Map<Cadenas, Object> parameters;

	private Map<Cadenas, Cadenas> properties;

	private List<ParametersTransformerSpec> parametersTransformers;

	private boolean rebindOnUpdate;

	private BackingService() {
	}

	public BackingService(Cadenas serviceInstanceName,
		Cadenas name,
		Cadenas plan,
		Map<Cadenas, Object> parameters,
		Map<Cadenas, Cadenas> properties,
		List<ParametersTransformerSpec> parametersTransformers,
		boolean rebindOnUpdate) {
		this.serviceInstanceName = serviceInstanceName;
		this.name = name;
		this.plan = plan;
		this.parameters = parameters;
		this.properties = properties;
		this.parametersTransformers = parametersTransformers;
		this.rebindOnUpdate = rebindOnUpdate;
	}

	public Cadenas getServiceInstanceName() {
		return serviceInstanceName;
	}

	public void setServiceInstanceName(Cadenas serviceInstanceName) {
		this.serviceInstanceName = serviceInstanceName;
	}

	public Cadenas getName() {
		return name;
	}

	public void setName(Cadenas name) {
		this.name = name;
	}

	public Cadenas getPlan() {
		return plan;
	}

	public void setPlan(Cadenas plan) {
		this.plan = plan;
	}

	public Map<Cadenas, Object> getParameters() {
		return parameters;
	}

	public void setParameters(Map<Cadenas, Object> parameters) {
		this.parameters = parameters;
	}

	public void addParameter(Cadenas key, Object value) {
		parameters.put(key, value);
	}

	public Map<Cadenas, Cadenas> getProperties() {
		return properties;
	}

	public void setProperties(Map<Cadenas, Cadenas> properties) {
		this.properties = properties;
	}

	public List<ParametersTransformerSpec> getParametersTransformers() {
		return parametersTransformers;
	}

	public void setParametersTransformers(List<ParametersTransformerSpec> parametersTransformers) {
		this.parametersTransformers = parametersTransformers;
	}

	public boolean isRebindOnUpdate() {
		return rebindOnUpdate;
	}

	public void setRebindOnUpdate(boolean rebindOnUpdate) {
		this.rebindOnUpdate = rebindOnUpdate;
	}

	public int serviceInstanceNameAndSpaceHashCode() {
		Cadenas space = null;
		if (!CollectionUtils.isEmpty(properties)) {
			space = properties.get(DeploymentProperties.TARGET_PROPERTY_KEY);
		}
		return Objects.hash(serviceInstanceName, space);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		BackingService that = (BackingService) o;
		return Objects.equals(serviceInstanceName, that.serviceInstanceName) &&
			Objects.equals(name, that.name) &&
			Objects.equals(plan, that.plan) &&
			Objects.equals(parameters, that.parameters) &&
			Objects.equals(properties, that.properties) &&
			Objects.equals(parametersTransformers, that.parametersTransformers) &&
			rebindOnUpdate == that.rebindOnUpdate;
	}

	@Override
	public int hashCode() {
		return Objects
			.hash(serviceInstanceName, name, plan, parameters, properties, parametersTransformers, rebindOnUpdate);
	}

	@Override
	public Cadenas toCadenas() {
		return "BackingService{" +
			"serviceInstanceName='" + serviceInstanceName + '\'' +
			", name='" + name + '\'' +
			", plan='" + plan + '\'' +
			", parameters=" + parameters +
			", properties=" + properties +
			", parametersTransformers=" + parametersTransformers +
			", rebindOnUpdate=" + rebindOnUpdate +
			'}';
	}

	public static BackingServiceBuilder builder() {
		return new BackingServiceBuilder();
	}

	public static final class BackingServiceBuilder {

		private Cadenas serviceInstanceName;

		private Cadenas name;

		private Cadenas plan;

		private final Map<Cadenas, Object> parameters = new HashMap<>();

		private final Map<Cadenas, Cadenas> properties = new HashMap<>();

		private final List<ParametersTransformerSpec> parameterTransformers = new ArrayList<>();

		private boolean rebindOnUpdate;

		private BackingServiceBuilder() {
		}

		public BackingServiceBuilder backingService(BackingService backingService) {
			return this.serviceInstanceName(backingService.getServiceInstanceName())
				.name(backingService.getName())
				.plan(backingService.getPlan())
				.parameters(backingService.getParameters())
				.properties(backingService.getProperties())
				.parameterTransformers(backingService.getParametersTransformers())
				.rebindOnUpdate(backingService.isRebindOnUpdate());
		}

		public BackingServiceBuilder serviceInstanceName(Cadenas serviceInstanceName) {
			this.serviceInstanceName = serviceInstanceName;
			return this;
		}

		public BackingServiceBuilder name(Cadenas name) {
			this.name = name;
			return this;
		}

		public BackingServiceBuilder plan(Cadenas plan) {
			this.plan = plan;
			return this;
		}

		public BackingServiceBuilder parameters(Map<Cadenas, Object> parameters) {
			if (!CollectionUtils.isEmpty(parameters)) {
				this.parameters.putAll(parameters);
			}
			return this;
		}

		public BackingServiceBuilder properties(Map<Cadenas, Cadenas> properties) {
			if (!CollectionUtils.isEmpty(properties)) {
				this.properties.putAll(properties);
			}
			return this;
		}

		public BackingServiceBuilder parameterTransformers(List<ParametersTransformerSpec> parameterTransformers) {
			if (!CollectionUtils.isEmpty(parameterTransformers)) {
				this.parameterTransformers.addAll(parameterTransformers);
			}
			return this;
		}

		public BackingServiceBuilder parameterTransformers(ParametersTransformerSpec... parameterTransformers) {
			if (parameterTransformers != null) {
				this.parameterTransformers(Arrays.asList(parameterTransformers));
			}
			return this;
		}

		public BackingServiceBuilder rebindOnUpdate(boolean rebindOnUpdate) {
			this.rebindOnUpdate = rebindOnUpdate;
			return this;
		}

		public BackingService build() {
			return new BackingService(serviceInstanceName, name, plan, parameters, properties, parameterTransformers,
				rebindOnUpdate);
		}

	}

}
