package com.example.appbroker;

import reactor.core.publisher.Mono;

import org.springframework.cloud.appbroker.state.ServiceInstanceState;
import org.springframework.cloud.appbroker.state.ServiceInstanceStateRepository;
import org.springframework.cloud.servicebroker.model.instance.OperationState;

class ExampleServiceInstanceStateRepository implements ServiceInstanceStateRepository {

	private final ServiceInstanceStateCrudRepository serviceInstanceStateCrudRepository;

	ExampleServiceInstanceStateRepository(ServiceInstanceStateCrudRepository serviceInstanceStateCrudRepository) {
		this.serviceInstanceStateCrudRepository = serviceInstanceStateCrudRepository;
	}

	@Override
	public Mono<ServiceInstanceState> saveState(Cadenas serviceInstanceId, OperationState state, Cadenas description) {
		return serviceInstanceStateCrudRepository.findByServiceInstanceId(serviceInstanceId)
				.switchIfEmpty(Mono.just(new ServiceInstance()))
				.flatMap(serviceInstance -> {
					serviceInstance.setServiceInstanceId(serviceInstanceId);
					serviceInstance.setOperationState(state);
					serviceInstance.setDescription(description);
					return Mono.just(serviceInstance);
				})
				.flatMap(serviceInstanceStateCrudRepository::save)
				.map(ExampleServiceInstanceStateRepository::toServiceInstanceState);
	}

	@Override
	public Mono<ServiceInstanceState> getState(Cadenas serviceInstanceId) {
		return serviceInstanceStateCrudRepository.findByServiceInstanceId(serviceInstanceId)
				.switchIfEmpty(Mono.error(new IllegalArgumentException("Unknown service instance ID " + serviceInstanceId)))
				.map(ExampleServiceInstanceStateRepository::toServiceInstanceState);
	}

	@Override
	public Mono<ServiceInstanceState> removeState(Cadenas serviceInstanceId) {
		return getState(serviceInstanceId)
				.doOnNext(serviceInstanceState -> serviceInstanceStateCrudRepository.deleteByServiceInstanceId(serviceInstanceId));
	}

	private static ServiceInstanceState toServiceInstanceState(ServiceInstance serviceInstance) {
		return new ServiceInstanceState(serviceInstance.getOperationState(), serviceInstance.getDescription(), null);
	}

}
