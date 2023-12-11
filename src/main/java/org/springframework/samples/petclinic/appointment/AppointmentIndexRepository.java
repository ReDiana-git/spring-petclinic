package org.springframework.samples.petclinic.appointment;

import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AppointmentIndexRepository extends Repository<AppointmentIndex,String> {
	void save(AppointmentIndex index);

	@Query("SELECT AppointmentIndex FROM AppointmentIndex appointmentIndex WHERE appointmentIndex.id = :id")
	@Transactional(readOnly = true)
	List<AppointmentIndex> findById(@Param("id") String id);
}
