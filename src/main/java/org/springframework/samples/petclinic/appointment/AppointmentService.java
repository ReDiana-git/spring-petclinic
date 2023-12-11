package org.springframework.samples.petclinic.appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
	@Autowired
	AppointRepository appointRepository;
	@Autowired
	AppointmentIndexRepository indexRepository;
	public void saveAppointment(AppointmentEntity appointmentEntity){
		appointRepository.save(appointmentEntity);
		indexRepository.save(new AppointmentIndex(appointmentEntity));
	}
	public List<AppointmentEntity> getAppointmentState(Integer owner_id){
		return appointRepository.findByOwnerId(owner_id);
	}
}
