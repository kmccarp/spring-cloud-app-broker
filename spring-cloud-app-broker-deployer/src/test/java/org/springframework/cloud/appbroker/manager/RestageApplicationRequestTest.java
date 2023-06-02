/*
 * Copyright 2002-2020 the original author or authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.appbroker.manager;

import java.util.Collections;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.data.MapEntry.entry;

class RestageApplicationRequestTest {

	@Test
	void builderWithNoValues() {
		RestageApplicationRequest request = RestageApplicationRequest.builder()
	.build();
		assertThat(request).isNotNull();
		assertThat(request.getName()).isNull();
		assertThat(request.getProperties()).isEmpty();
	}

	@Test
	void builderWithValues() {
		RestageApplicationRequest request = RestageApplicationRequest.builder()
	.name("foo")
	.properties(Collections.singletonMap("foo", "bar"))
	.build();
		assertThat(request).isNotNull();
		assertThat(request.getName()).isEqualTo("foo");
		assertThat(request.getProperties()).containsOnly(entry("foo", "bar"));
	}

	@Test
	void builderAcceptsNullProperties() {
		RestageApplicationRequest request = RestageApplicationRequest.builder()
	.name("foo")
	.properties(null)
	.build();
		assertThat(request).isNotNull();
		assertThat(request.getName()).isEqualTo("foo");
		assertThat(request.getProperties()).isEmpty();
	}

	@Test
	void builderAcceptsEmptyProperties() {
		RestageApplicationRequest request = RestageApplicationRequest.builder()
	.name("foo")
	.properties(Collections.emptyMap())
	.build();
		assertThat(request).isNotNull();
		assertThat(request.getName()).isEqualTo("foo");
		assertThat(request.getProperties()).isEmpty();
	}

}
