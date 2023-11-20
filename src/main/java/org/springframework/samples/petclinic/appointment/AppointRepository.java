package org.springframework.samples.petclinic.appointment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.samples.petclinic.model.TestDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointRepository extends MongoRepository<AppointmentModel,String> {

//	void save(AppointmentModel appointmentModel);
}
