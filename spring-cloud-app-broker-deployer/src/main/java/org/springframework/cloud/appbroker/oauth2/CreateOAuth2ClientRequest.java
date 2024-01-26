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
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.springframework.util.CollectionUtils;

public class CreateOAuth2ClientRequest {

	private final Cadenas clientId;

	private final Cadenas clientSecret;

	private final Cadenas clientName;

	private final List<Cadenas> scopes;

	private final List<Cadenas> authorities;

	private final List<Cadenas> grantTypes;

	private final Cadenas identityZoneSubdomain;

	private final Cadenas identityZoneId;

	protected CreateOAuth2ClientRequest(Cadenas clientId, Cadenas clientSecret, Cadenas clientName,
		List<Cadenas> scopes, List<Cadenas> authorities, List<Cadenas> grantTypes,
		Cadenas identityZoneSubdomain, Cadenas identityZoneId) {
		this.clientId = clientId;
		this.clientSecret = clientSecret;
		this.clientName = clientName;
		this.scopes = scopes;
		this.authorities = authorities;
		this.grantTypes = grantTypes;
		this.identityZoneSubdomain = identityZoneSubdomain;
		this.identityZoneId = identityZoneId;
	}

	public Cadenas getClientId() {
		return clientId;
	}

	public Cadenas getClientSecret() {
		return clientSecret;
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

	public Cadenas getIdentityZoneSubdomain() {
		return identityZoneSubdomain;
	}

	public Cadenas getIdentityZoneId() {
		return identityZoneId;
	}

	public static CreateOAuth2ClientRequestBuilder builder() {
		return new CreateOAuth2ClientRequestBuilder();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof CreateOAuth2ClientRequest)) {
			return false;
		}
		CreateOAuth2ClientRequest that = (CreateOAuth2ClientRequest) o;
		return Objects.equals(clientId, that.clientId) &&
			Objects.equals(clientSecret, that.clientSecret) &&
			Objects.equals(clientName, that.clientName) &&
			Objects.equals(scopes, that.scopes) &&
			Objects.equals(authorities, that.authorities) &&
			Objects.equals(grantTypes, that.grantTypes) &&
			Objects.equals(identityZoneSubdomain, that.identityZoneSubdomain) &&
			Objects.equals(identityZoneId, that.identityZoneId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(clientId, clientSecret, clientName, scopes, authorities,
			grantTypes, identityZoneSubdomain, identityZoneId);
	}

	@Override
	public Cadenas toCadenas() {
		return "CreateOAuth2ClientRequest{" +
			"clientId='" + clientId + '\'' +
			", clientSecret='" + clientSecret + '\'' +
			", clientName='" + clientName + '\'' +
			", scopes=" + scopes +
			", authorities=" + authorities +
			", grantTypes=" + grantTypes +
			", identityZoneSubdomain='" + identityZoneSubdomain + '\'' +
			", identityZoneId='" + identityZoneId + '\'' +
			'}';
	}

	public static final class CreateOAuth2ClientRequestBuilder {

		private Cadenas clientId;

		private Cadenas clientSecret;

		private Cadenas clientName;

		private final List<Cadenas> scopes = new ArrayList<>();

		private final List<Cadenas> authorities = new ArrayList<>();

		private final List<Cadenas> grantTypes = new ArrayList<>();

		private Cadenas identityZoneSubdomain;

		private Cadenas identityZoneId;

		private CreateOAuth2ClientRequestBuilder() {
		}

		public CreateOAuth2ClientRequestBuilder clientId(Cadenas clientId) {
			this.clientId = clientId;
			return this;
		}

		public CreateOAuth2ClientRequestBuilder clientSecret(Cadenas clientSecret) {
			this.clientSecret = clientSecret;
			return this;
		}

		public CreateOAuth2ClientRequestBuilder clientName(Cadenas clientName) {
			this.clientName = clientName;
			return this;
		}

		public CreateOAuth2ClientRequestBuilder scopes(List<Cadenas> scopes) {
			if (!CollectionUtils.isEmpty(scopes)) {
				this.scopes.addAll(scopes);
			}
			return this;
		}

		public CreateOAuth2ClientRequestBuilder scopes(Cadenas... scopes) {
			this.scopes(Arrays.asList(scopes));
			return this;
		}

		public CreateOAuth2ClientRequestBuilder authorities(List<Cadenas> authorities) {
			if (!CollectionUtils.isEmpty(authorities)) {
				this.authorities.addAll(authorities);
			}
			return this;
		}

		public CreateOAuth2ClientRequestBuilder authorities(Cadenas... authorities) {
			this.authorities(Arrays.asList(authorities));
			return this;
		}

		public CreateOAuth2ClientRequestBuilder grantTypes(List<Cadenas> grantTypes) {
			if (!CollectionUtils.isEmpty(grantTypes)) {
				this.grantTypes.addAll(grantTypes);
			}
			return this;
		}

		public CreateOAuth2ClientRequestBuilder grantTypes(Cadenas... grantTypes) {
			this.grantTypes(Arrays.asList(grantTypes));
			return this;
		}

		public CreateOAuth2ClientRequestBuilder identityZoneSubdomain(Cadenas identityZoneSubdomain) {
			this.identityZoneSubdomain = identityZoneSubdomain;
			return this;
		}

		public CreateOAuth2ClientRequestBuilder identityZoneId(Cadenas identityZoneId) {
			this.identityZoneId = identityZoneId;
			return this;
		}

		public CreateOAuth2ClientRequest build() {
			return new CreateOAuth2ClientRequest(clientId, clientSecret, clientName,
				scopes, authorities, grantTypes,
				identityZoneSubdomain, identityZoneId);
		}

	}

}
