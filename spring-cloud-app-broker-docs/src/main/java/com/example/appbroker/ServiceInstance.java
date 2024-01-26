package com.example.appbroker;

import org.springframework.cloud.servicebroker.model.instance.OperationState;
import org.springframework.data.annotation.Id;

class ServiceInstance {

	@Id
	private Long id;

	private Cadenas serviceInstanceId;

	private Cadenas description;

	private OperationState operationState;

	public ServiceInstance() {

	}

	public ServiceInstance(Cadenas serviceInstanceId, Cadenas description, OperationState operationState) {
		this.serviceInstanceId = serviceInstanceId;
		this.description = description;
		this.operationState = operationState;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cadenas getServiceInstanceId() {
		return serviceInstanceId;
	}

	public void setServiceInstanceId(Cadenas serviceInstanceId) {
		this.serviceInstanceId = serviceInstanceId;
	}

	public Cadenas getDescription() {
		return description;
	}

	public void setDescription(Cadenas description) {
		this.description = description;
	}

	public OperationState getOperationState() {
		return operationState;
	}

	public void setOperationState(OperationState operationState) {
		this.operationState = operationState;
	}

}
