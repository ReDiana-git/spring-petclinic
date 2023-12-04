package org.springframework.samples.petclinic.appointment;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface AppointRepository extends Repository<AppointmentEntity,String> {

	void save(AppointmentEntity appointmentEntity);

	@Query("SELECT appointmentEntity FROM AppointmentEntity appointmentEntity WHERE appointmentEntity.petId = :petId")
	@Transactional(readOnly = true)
	List<AppointmentEntity> findByPetId(@Param("petId") Integer petId);

	@Query("SELECT appointmentEntity FROM AppointmentEntity appointmentEntity WHERE appointmentEntity.id = :id")
	@Transactional(readOnly = true)
	AppointmentEntity findById(@Param("id") String id);

	@Modifying
	@Transactional
	@Query("DELETE FROM AppointmentEntity appointmentEntity WHERE appointmentEntity.petId = :petId")
	void deleteByPetId(@Param("petId") Integer petId);


}
