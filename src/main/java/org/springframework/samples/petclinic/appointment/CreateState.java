package org.springframework.samples.petclinic.appointment;

public class CreateState implements AppointmentState{


	private AppointmentEntity appointmentEntity;

	public CreateState(AppointmentEntity appointmentEntity){
		appointmentEntity = this.appointmentEntity;

	}
	@Override
	public void handleState(AppointmentContext context) {
		//TODO
		//確認醫生行程表
	}
}
