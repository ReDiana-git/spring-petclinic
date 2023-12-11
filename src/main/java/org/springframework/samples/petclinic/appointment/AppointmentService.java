package org.springframework.samples.petclinic.appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentService {
	@Autowired
	AppointRepository appointRepository;
	@Autowired
	AppointmentIndexRepository indexRepository;
	@Autowired
	ConsultationRepository consultationRepository;
	public void saveAppointment(AppointmentEntity appointmentEntity){
		appointRepository.save(appointmentEntity);
		indexRepository.save(new AppointmentIndex(appointmentEntity));
	}
	public List<?> getAppointments(Integer owner_id){
		List<AppointmentIndex> appointmentsId = indexRepository.findByOwnerId(owner_id);
		return appointmentsId;
//		List<AppointmentEntity> appointmentEntities = new ArrayList<>();
//		for(AppointmentIndex appoint :appointmentsId){
//			System.out.println(appoint.getId());
//			switch (appoint.getState()){
//				case INIT :
//					appointmentEntities.add(appointRepository.findById(appoint.getId()));
//					break;
//				case CONSULTAION:
//					appointmentEntities.add(consultationRepository.findById(appoint.getId()));
//					break;
//				case PAYMENT:
//					//TODO
//					break;
//				case MEDICATION:
//					//TODO
//					break;
//			}
//
//		}
//		return appointmentEntities;
	}
}
