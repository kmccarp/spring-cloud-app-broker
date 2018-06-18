/*
 * Copyright 2016-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.appbroker.workflow;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.appbroker.workflow.action.createserviceinstance.CreateServiceRequestContext;
import org.springframework.cloud.appbroker.workflow.action.createserviceinstance.DefaultCreateServiceBrokerResponseBuilder;
import org.springframework.cloud.appbroker.workflow.action.createserviceinstance.appdeploy.BackingAppDeployer;
import org.springframework.cloud.appbroker.workflow.action.createserviceinstance.appdeploy.BackingAppDeploymentPlan;
import org.springframework.cloud.appbroker.workflow.action.createserviceinstance.appdeploy.BackingAppParameters;
import org.springframework.cloud.servicebroker.model.instance.CreateServiceInstanceRequest;
import org.springframework.cloud.servicebroker.model.instance.CreateServiceInstanceResponse;

public class CreateServiceInstanceDefaultWorkflow implements CreateServiceInstanceWorkflow<CreateServiceInstanceRequest, CreateServiceInstanceResponse> {

	private Set<BackingAppDeploymentPlan> deploymentPlans;
	private DefaultCreateServiceBrokerResponseBuilder createServiceBrokerResponseBuilder;

	@Autowired
	public CreateServiceInstanceDefaultWorkflow(Set<BackingAppDeploymentPlan> deploymentPlans,
												DefaultCreateServiceBrokerResponseBuilder createServiceBrokerResponseBuilder) {
		this.deploymentPlans = deploymentPlans;
		this.createServiceBrokerResponseBuilder = createServiceBrokerResponseBuilder;
	}

	@Override
	public CreateServiceInstanceResponse perform(CreateServiceInstanceRequest requestData) {
		CreateServiceRequestContext requestContext = new CreateServiceRequestContext(requestData);
		deploymentPlans.forEach(plan -> plan.getBackingAppDeployer().accept(plan.getBackingAppParameters(), requestContext));
		return createServiceBrokerResponseBuilder.apply(requestContext);
	}

}
