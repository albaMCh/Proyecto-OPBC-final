package com.albamch.userservice.ExceptionHandler;

import lombok.Data;

@Data
public class  CustomErrorResponse extends RuntimeException {

	private String exMessage;

	public CustomErrorResponse(Class cla, String mensaje, String exmensaje) {
		super("Class name: " + cla.getSimpleName()+", "+mensaje);
		this.exMessage = exmensaje;
	}
}
