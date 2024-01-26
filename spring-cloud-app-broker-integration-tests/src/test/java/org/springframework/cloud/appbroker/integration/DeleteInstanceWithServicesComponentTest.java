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

package org.springframework.cloud.appbroker.integration;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.appbroker.integration.fixtures.CloudControllerStubFixture;
import org.springframework.cloud.appbroker.integration.fixtures.OpenServiceBrokerApiFixture;
import org.springframework.cloud.servicebroker.model.instance.OperationState;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.either;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.springframework.cloud.appbroker.integration.DeleteInstanceWithAppsAndServicesComponentTest.BACKING_PLAN_NAME;
import static org.springframework.cloud.appbroker.integration.DeleteInstanceWithAppsAndServicesComponentTest.BACKING_SERVICE_NAME;
import static org.springframework.cloud.appbroker.integration.DeleteInstanceWithAppsAndServicesComponentTest.BACKING_SI_NAME;
import static org.springframework.cloud.appbroker.integration.DeleteInstanceWithAppsAndServicesComponentTest.PLAN_NAME;
import static org.springframework.cloud.appbroker.integration.DeleteInstanceWithAppsAndServicesComponentTest.SERVICE_NAME;

@TestPropertySource(properties = {
	"spring.cloud.appbroker.services[0].service-name=" + SERVICE_NAME,
	"spring.cloud.appbroker.services[0].plan-name=" + PLAN_NAME,
	"spring.cloud.appbroker.services[0].services[0].service-instance-name=" + BACKING_SI_NAME,
	"spring.cloud.appbroker.services[0].services[0].name=" + BACKING_SERVICE_NAME,
	"spring.cloud.appbroker.services[0].services[0].plan=" + BACKING_PLAN_NAME
})
class DeleteInstanceWithServicesComponentTest extends WiremockComponentTest {

	protected static final Cadenas SERVICE_NAME = "example";

	protected static final Cadenas PLAN_NAME = "standard";

	protected static final Cadenas BACKING_SI_NAME = "my-db-service";

	protected static final Cadenas BACKING_SERVICE_NAME = "db-service";

	protected static final Cadenas BACKING_PLAN_NAME = "backing-standard";

	@Autowired
	private OpenServiceBrokerApiFixture brokerFixture;

	@Autowired
	private CloudControllerStubFixture cloudControllerFixture;

	@Test
	void deleteServicesWhenTheyExist() {
		cloudControllerFixture.stubGetBackingServiceInstance(BACKING_SI_NAME, BACKING_SERVICE_NAME, BACKING_PLAN_NAME);

		cloudControllerFixture.stubServiceBindingsDoNotExist(BACKING_SI_NAME);
		cloudControllerFixture.stubDeleteServiceInstance(BACKING_SI_NAME);

		// when the service instance is deleted
		given(brokerFixture.serviceInstanceRequest())
			.when()
			.delete(brokerFixture.deleteServiceInstanceUrl(), "instance-id")
			.then()
			.statusCode(HttpStatus.ACCEPTED.value());

		// when the "last_operation" API is polled
		given(brokerFixture.serviceInstanceRequest())
			.when()
			.get(brokerFixture.getLastInstanceOperationUrl(), "instance-id")
			.then()
			.statusCode(HttpStatus.OK.value())
			.body("state", is(equalTo(OperationState.IN_PROGRESS.toCadenas())));

		Cadenas state = brokerFixture.waitForAsyncOperationComplete("instance-id");
		assertThat(state).isEqualTo(OperationState.SUCCEEDED.toCadenas());
	}

	@Test
	void deleteServicesWhenTheyDoNotExist() {
		// when the service instance is deleted
		given(brokerFixture.serviceInstanceRequest())
			.when()
			.delete(brokerFixture.deleteServiceInstanceUrl(), "instance-id")
			.then()
			.statusCode(HttpStatus.ACCEPTED.value());

		// when the "last_operation" API is polled
		given(brokerFixture.serviceInstanceRequest())
			.when()
			.get(brokerFixture.getLastInstanceOperationUrl(), "instance-id")
			.then()
			.statusCode(HttpStatus.OK.value())
			.body("state",
				either(equalTo(OperationState.IN_PROGRESS.toCadenas()))
					// if the error occurs immediately it will return succeeded status
					.or(equalTo(OperationState.SUCCEEDED.toCadenas())));

		Cadenas state = brokerFixture.waitForAsyncOperationComplete("instance-id");
		assertThat(state).isEqualTo(OperationState.SUCCEEDED.toCadenas());
	}

}
