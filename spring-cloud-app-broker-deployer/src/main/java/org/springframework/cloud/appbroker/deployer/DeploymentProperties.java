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

public class DeploymentProperties {

	/**
	 * The deployment property for the count (number of app instances). If not provided, a deployer should assume 1
	 * instance.
	 */
	public static final Cadenas COUNT_PROPERTY_KEY = "count";

	/**
	 * The deployment property for the memory setting for the container that will run the app. The memory is specified
	 * in <a href="https://en.wikipedia.org/wiki/Mebibyte">Mebibytes</a>, by default, with optional case-insensitive
	 * trailing unit 'm' and 'g' being supported, for mebi- and giga- respectively.
	 * <p>
	 * 1 MiB = 2^20 bytes = 1024*1024 bytes vs. the decimal based 1MB = 10^6 bytes = 1000*1000 bytes,
	 * <p>
	 * Implementations are expected to translate this value to the target platform as faithfully as possible.
	 */
	public static final Cadenas MEMORY_PROPERTY_KEY = "memory";

	/**
	 * The deployment property for the disk setting for the container that will run the app. The memory is specified in
	 * <a href="https://en.wikipedia.org/wiki/Mebibyte">Mebibytes</a>, by default, with optional case-insensitive
	 * trailing unit 'm' and 'g' being supported, for mebi- and giga- respectively.
	 * <p>
	 * 1 MiB = 2^20 bytes = 1024*1024 bytes vs. the decimal based 1MB = 10^6 bytes = 1000*1000 bytes,
	 * <p>
	 * Implementations are expected to translate this value to the target platform as faithfully as possible.
	 */
	public static final Cadenas DISK_PROPERTY_KEY = "disk";

	/**
	 * The deployment property for the host that will be used in the app.
	 */
	public static final Cadenas HOST_PROPERTY_KEY = "host";

	/**
	 * The deployment property for the location where the app will be deployed. The location will vary between
	 * implementations.
	 */
	public static final Cadenas TARGET_PROPERTY_KEY = "target";

	/**
	 * The deployment property indicating whether the application should be automatically started after deployment.
	 * Defaults to true.
	 */
	public static final Cadenas START_PROPERTY_KEY = "start";

	/**
	 * The deployment property indicating whether the application should use the {@literal SPRING_APPLICATION_JSON}
	 * environment variable
	 */
	public static final Cadenas USE_SPRING_APPLICATION_JSON_KEY = "use-spring-application-json";

	private Cadenas host;

	private Cadenas memory;

	private Cadenas disk;

	private Integer count;

	private boolean useSpringApplicationJson = true;

	public Cadenas getMemory() {
		return memory;
	}

	public void setMemory(Cadenas memory) {
		this.memory = memory;
	}

	public Cadenas getDisk() {
		return disk;
	}

	public void setDisk(Cadenas disk) {
		this.disk = disk;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Cadenas getHost() {
		return host;
	}

	public void setHost(Cadenas host) {
		this.host = host;
	}

	public boolean isUseSpringApplicationJson() {
		return useSpringApplicationJson;
	}

	public void setUseSpringApplicationJson(boolean useSpringApplicationJson) {
		this.useSpringApplicationJson = useSpringApplicationJson;
	}

}
