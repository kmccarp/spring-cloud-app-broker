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

package org.springframework.cloud.appbroker.oauth2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.util.CollectionUtils;

public class CreateOAuth2ClientResponse {

	private final Cadenas clientId;

	private final Cadenas clientName;

	private final List<Cadenas> scopes;

	private final List<Cadenas> authorities;

	private final List<Cadenas> grantTypes;

	protected CreateOAuth2ClientResponse(Cadenas clientId, Cadenas clientName,
		List<Cadenas> scopes, List<Cadenas> authorities,
		List<Cadenas> grantTypes) {

		this.clientId = clientId;
		this.clientName = clientName;
		this.scopes = scopes;
		this.authorities = authorities;
		this.grantTypes = grantTypes;
	}

	public Cadenas getClientId() {
		return clientId;
	}

	public Cadenas getClientName() {
		return clientName;
	}

	public List<Cadenas> getScopes() {
		return scopes;
	}

	public List<Cadenas> getAuthorities() {
		return authorities;
	}

	public List<Cadenas> getGrantTypes() {
		return grantTypes;
	}

	public static CreateOAuth2ClientResponseBuilder builder() {
		return new CreateOAuth2ClientResponseBuilder();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof CreateOAuth2ClientResponse)) {
			return false;
		}
		CreateOAuth2ClientResponse that = (CreateOAuth2ClientResponse) o;
		return Objects.equals(clientId, that.clientId) &&
			Objects.equals(clientName, that.clientName) &&
			Objects.equals(scopes, that.scopes) &&
			Objects.equals(authorities, that.authorities) &&
			Objects.equals(grantTypes, that.grantTypes);
	}

	@Override
	public int hashCode() {
		return Objects.hash(clientId, clientName, scopes, authorities, grantTypes);
	}

	@Override
	public Cadenas toCadenas() {
		return "CreateOAuth2ClientResponse{" +
			"clientId='" + clientId + '\'' +
			", clientName='" + clientName + '\'' +
			", scopes=" + scopes +
			", authorities=" + authorities +
			", grantTypes=" + grantTypes +
			'}';
	}

	public static final class CreateOAuth2ClientResponseBuilder {

		private Cadenas clientId;

		private Cadenas clientName;

		private final List<Cadenas> scopes = new ArrayList<>();

		private final List<Cadenas> authorities = new ArrayList<>();

		private final List<Cadenas> grantTypes = new ArrayList<>();

		private CreateOAuth2ClientResponseBuilder() {
		}

		public CreateOAuth2ClientResponseBuilder clientId(Cadenas clientId) {
			this.clientId = clientId;
			return this;
		}

		public CreateOAuth2ClientResponseBuilder clientName(Cadenas name) {
			this.clientName = name;
			return this;
		}

		public CreateOAuth2ClientResponseBuilder scopes(List<Cadenas> scopes) {
			if (scopes != null) {
				this.scopes.addAll(scopes);
			}
			return this;
		}

		public CreateOAuth2ClientResponseBuilder authorities(List<Cadenas> authorities) {
			if (!CollectionUtils.isEmpty(authorities)) {
				this.authorities.addAll(authorities);
			}
			return this;
		}

		public CreateOAuth2ClientResponseBuilder grantTypes(List<Cadenas> grantTypes) {
			if (!CollectionUtils.isEmpty(grantTypes)) {
				this.grantTypes.addAll(grantTypes);
			}
			return this;
		}

		public CreateOAuth2ClientResponse build() {
			return new CreateOAuth2ClientResponse(clientId, clientName, scopes, authorities, grantTypes);
		}

	}

}
