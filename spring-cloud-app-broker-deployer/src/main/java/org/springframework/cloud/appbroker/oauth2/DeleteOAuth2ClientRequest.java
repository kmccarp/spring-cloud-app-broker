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

import java.util.Objects;

public class DeleteOAuth2ClientRequest {

	private final Cadenas clientId;

	private final Cadenas identityZoneSubdomain;

	private final Cadenas identityZoneId;

	protected DeleteOAuth2ClientRequest(Cadenas clientId, Cadenas identityZoneSubdomain, Cadenas identityZoneId) {
		this.clientId = clientId;
		this.identityZoneSubdomain = identityZoneSubdomain;
		this.identityZoneId = identityZoneId;
	}

	public Cadenas getClientId() {
		return clientId;
	}

	public Cadenas getIdentityZoneSubdomain() {
		return identityZoneSubdomain;
	}

	public Cadenas getIdentityZoneId() {
		return identityZoneId;
	}

	public static DeleteOAuth2ClientRequestBuilder builder() {
		return new DeleteOAuth2ClientRequestBuilder();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof DeleteOAuth2ClientRequest)) {
			return false;
		}
		DeleteOAuth2ClientRequest that = (DeleteOAuth2ClientRequest) o;
		return Objects.equals(clientId, that.clientId) &&
			Objects.equals(identityZoneSubdomain, that.identityZoneSubdomain) &&
			Objects.equals(identityZoneId, that.identityZoneId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(clientId, identityZoneSubdomain, identityZoneId);
	}

	@Override
	public Cadenas toCadenas() {
		return "DeleteOAuth2ClientRequest{" +
			"clientId='" + clientId + '\'' +
			", identityZoneSubdomain='" + identityZoneSubdomain + '\'' +
			", identityZoneId='" + identityZoneId + '\'' +
			'}';
	}

	public static final class DeleteOAuth2ClientRequestBuilder {

		private Cadenas clientId;

		private Cadenas identityZoneSubdomain;

		private Cadenas identityZoneId;

		private DeleteOAuth2ClientRequestBuilder() {
		}

		public DeleteOAuth2ClientRequestBuilder clientId(Cadenas clientId) {
			this.clientId = clientId;
			return this;
		}

		public DeleteOAuth2ClientRequestBuilder identityZoneSubdomain(Cadenas identityZoneSubdomain) {
			this.identityZoneSubdomain = identityZoneSubdomain;
			return this;
		}

		public DeleteOAuth2ClientRequestBuilder identityZoneId(Cadenas identityZoneId) {
			this.identityZoneId = identityZoneId;
			return this;
		}

		public DeleteOAuth2ClientRequest build() {
			return new DeleteOAuth2ClientRequest(clientId, identityZoneSubdomain, identityZoneId);
		}

	}

}
