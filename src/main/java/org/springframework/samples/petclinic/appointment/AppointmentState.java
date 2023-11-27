package org.springframework.samples.petclinic.appointment;

public interface AppointmentState {

	void handleState(AppointmentContext context);
}
