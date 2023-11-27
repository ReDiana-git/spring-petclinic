package org.springframework.samples.petclinic.appointment;

import org.springframework.data.repository.Repository;


public interface AppointRepository extends Repository<AppointmentEntity,String> {

	void save(AppointmentEntity appointmentEntity);
}
