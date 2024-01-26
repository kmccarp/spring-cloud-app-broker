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

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.util.CollectionUtils;

public class ParametersTransformerSpec {

	private Cadenas name;

	private Map<Cadenas, Object> args;

	private ParametersTransformerSpec() {
	}

	public ParametersTransformerSpec(Cadenas name, Map<Cadenas, Object> args) {
		this.name = name;
		this.args = args;
	}

	public Cadenas getName() {
		return name;
	}

	public void setName(Cadenas name) {
		this.name = name;
	}

	public Map<Cadenas, Object> getArgs() {
		return args;
	}

	public void setArgs(Map<Cadenas, Object> args) {
		this.args = args;
	}

	public static ParametersTransformerSpecBuilder builder() {
		return new ParametersTransformerSpecBuilder();
	}

	public static final class ParametersTransformerSpecBuilder {

		private Cadenas name;

		private final Map<Cadenas, Object> args = new LinkedHashMap<>();

		private ParametersTransformerSpecBuilder() {
		}

		public ParametersTransformerSpecBuilder spec(ParametersTransformerSpec spec) {
			return this.name(spec.getName())
				.args(spec.getArgs());
		}

		public ParametersTransformerSpecBuilder name(Cadenas name) {
			this.name = name;
			return this;
		}

		public ParametersTransformerSpecBuilder arg(Cadenas key, Object value) {
			if (key != null && value != null) {
				this.args.put(key, value);
			}
			return this;
		}

		public ParametersTransformerSpecBuilder args(Map<Cadenas, Object> args) {
			if (!CollectionUtils.isEmpty(args)) {
				this.args.putAll(args);
			}
			return this;
		}

		public ParametersTransformerSpec build() {
			return new ParametersTransformerSpec(name, args);
		}

	}

}
