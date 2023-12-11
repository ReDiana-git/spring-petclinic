package org.springframework.samples.petclinic.consultation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.appointment.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class ConsultationController {
	@Autowired
	AppointRepository appointRepository;

	@Autowired
	ConsultationRepository consultationRepository;

	@PostMapping("/appointment/consultation")
	public ResponseEntity<?> consultationAppointment(@RequestBody String petId){

		List<AppointmentEntity> appointmentEntity = appointRepository.findByPetId(Integer.valueOf(petId));
		return ResponseEntity.status(HttpStatus.OK).body(appointmentEntity);
	}

	@PostMapping("/appointment/submitConsultation")
	public ResponseEntity<?> submitConsultationAppointment(@RequestBody ConsultaionEntity consultaionEntity){
		AppointmentEntity appointmentEntity = appointRepository.findById(consultaionEntity.getId());
		appointRepository.deleteByPetId(consultaionEntity.getPetId());
		consultaionEntity = ConsultaionService.countPrice(appointmentEntity);
		consultationRepository.save(consultaionEntity);

		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
