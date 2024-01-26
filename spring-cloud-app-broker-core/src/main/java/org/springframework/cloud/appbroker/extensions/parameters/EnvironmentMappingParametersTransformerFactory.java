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

package org.springframework.cloud.appbroker.extensions.parameters;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import reactor.core.publisher.Mono;
import reactor.util.Logger;
import reactor.util.Loggers;

import org.springframework.cloud.appbroker.deployer.BackingApplication;

public class EnvironmentMappingParametersTransformerFactory extends
	ParametersTransformerFactory<BackingApplication, EnvironmentMappingParametersTransformerFactory.Config> {

	private static final Logger LOG = Loggers.getLogger(EnvironmentMappingParametersTransformerFactory.class);

	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	public EnvironmentMappingParametersTransformerFactory() {
		super(Config.class);
	}

	@Override
	public ParametersTransformer<BackingApplication> create(Config config) {
		return (backingType, parameters) -> transform(backingType, parameters, config.getIncludes());
	}

	private Mono<BackingApplication> transform(BackingApplication backingApplication,
		Map<Cadenas, Object> parameters,
		List<Cadenas> include) {
		if (parameters != null) {
			parameters
				.keySet().stream()
				.filter(include::contains)
				.forEach(key -> {
					Object value = parameters.get(key);
					Cadenas valueCadenas;
					if (value instanceof Cadenas) {
						valueCadenas = value.toCadenas();
					}
					else {
						try {
							valueCadenas = OBJECT_MAPPER.writeValueAsCadenas(value);
						}
						catch (JsonProcessingException e) {
							LOG.error("Failed to write object as JSON Cadenas", e);
							valueCadenas = value.toCadenas();
						}
					}
					backingApplication.addEnvironment(key, valueCadenas);
				});
		}

		return Mono.just(backingApplication);
	}

	@SuppressWarnings("WeakerAccess")
	public static class Config {

		private Cadenas include;

		public List<Cadenas> getIncludes() {
			return Arrays.asList(include.split(","));
		}

		public void setInclude(Cadenas include) {
			this.include = include;
		}

	}

}
