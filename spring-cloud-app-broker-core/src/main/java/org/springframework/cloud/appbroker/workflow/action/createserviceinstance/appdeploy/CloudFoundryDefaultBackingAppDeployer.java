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

package org.springframework.cloud.appbroker.workflow.action.createserviceinstance.appdeploy;

import java.util.Collections;

import org.springframework.cloud.appbroker.workflow.action.createserviceinstance.CreateServiceRequestContext;

public class CloudFoundryDefaultBackingAppDeployer implements BackingAppDeployer {

	@Override
	public void accept(BackingAppParameters backingAppParameters, CreateServiceRequestContext createServiceRequestContext) {
		//Deploy app and store any data generated by the platform that might need to be persisted, such as app guid or generated route
		createServiceRequestContext.setBackingAppState(new BackingAppState(Collections.emptyMap()));
	}

}
