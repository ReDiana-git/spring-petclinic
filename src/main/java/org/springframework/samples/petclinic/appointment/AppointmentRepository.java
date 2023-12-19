package org.springframework.samples.petclinic.appointment;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.stereotype.Repository
public interface AppointmentRepository extends Repository<AppointmentEntity,String> {

	void save(AppointmentEntity appointmentEntity);

	AppointmentEntity findById(String id);

//	@Query("SELECT appointmentEntity FROM AppointmentEntity appointmentEntity WHERE appointmentEntity.id = :id")
//	@Transactional(readOnly = true)
//	AppointmentEntity findById(@Param("id") String id);



}
