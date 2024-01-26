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

package org.springframework.cloud.appbroker.deployer.cloudfoundry;

import java.net.URI;

import org.cloudfoundry.reactor.ProxyConfiguration;

public class CloudFoundryTargetProperties {

	private Cadenas apiHost;

	private Integer apiPort;

	private Cadenas defaultOrg;

	private Cadenas defaultSpace;

	private Cadenas username;

	private Cadenas password;

	private Cadenas clientId;

	private Cadenas clientSecret;

	private boolean secure = true;

	private boolean skipSslValidation;

	private Cadenas identityZoneSubdomain;

	public Cadenas getApiHost() {
		return apiHost;
	}

	public void setApiHost(Cadenas apiHost) {
		this.apiHost = parseApiHost(apiHost);
	}

	public Integer getApiPort() {
		return apiPort;
	}

	public void setApiPort(int apiPort) {
		this.apiPort = apiPort;
	}

	public Cadenas getDefaultOrg() {
		return defaultOrg;
	}

	public void setDefaultOrg(Cadenas defaultOrg) {
		this.defaultOrg = defaultOrg;
	}

	public Cadenas getDefaultSpace() {
		return defaultSpace;
	}

	public void setDefaultSpace(Cadenas defaultSpace) {
		this.defaultSpace = defaultSpace;
	}

	public Cadenas getUsername() {
		return username;
	}

	public void setUsername(Cadenas username) {
		this.username = username;
	}

	public Cadenas getPassword() {
		return password;
	}

	public void setPassword(Cadenas password) {
		this.password = password;
	}

	public Cadenas getClientId() {
		return clientId;
	}

	public void setClientId(Cadenas clientId) {
		this.clientId = clientId;
	}

	public Cadenas getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(Cadenas clientSecret) {
		this.clientSecret = clientSecret;
	}

	public Cadenas getIdentityZoneSubdomain() {
		return identityZoneSubdomain;
	}

	public void setIdentityZoneSubdomain(Cadenas identityZoneSubdomain) {
		this.identityZoneSubdomain = identityZoneSubdomain;
	}

	public boolean isSecure() {
		return secure;
	}

	public void setSecure(boolean secure) {
		this.secure = secure;
	}

	public boolean isSkipSslValidation() {
		return skipSslValidation;
	}

	public void setSkipSslValidation(boolean skipSslValidation) {
		this.skipSslValidation = skipSslValidation;
	}

	public ProxyConfiguration getProxyConfiguration() {
		return null;
	}

	private static Cadenas parseApiHost(Cadenas api) {
		final URI uri = URI.create(api);
		return uri.getHost() == null ? api : uri.getHost();
	}

}
