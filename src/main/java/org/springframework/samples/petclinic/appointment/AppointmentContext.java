package org.springframework.samples.petclinic.appointment;

public class AppointmentContext {
	private AppointmentState state;

	public AppointmentContext(AppointmentEntity appointmentEntity){
		state = new CreateState(appointmentEntity);
	}

	public void setState(AppointmentState state){
		this.state = state;
	}
	public void handleAppointment(){
		state.handleState(this);
	}
}
