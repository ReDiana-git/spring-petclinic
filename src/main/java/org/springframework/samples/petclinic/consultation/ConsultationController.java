package org.springframework.samples.petclinic.consultation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.appointment.*;
import org.springframework.samples.petclinic.medicalRecord.MedicalRecordRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ConsultationController {
	@Autowired
    AppointmentRepository appointmentRepository;
	@Autowired
	MedicalRecordRepository medicalRecordRepository;
	@Autowired
	ConsultationRepository consultationRepository;
	@Autowired
	ConsultationService consultationService = new ConsultationService();
	@PostMapping("/appointment/checkConsultation")
	public ResponseEntity<?> checkConsultation(@RequestBody String recordId){
		System.out.println(recordId);
		ConsultationDTO consultationDTO = consultationService.checkConsultaion(recordId);
		return ResponseEntity.status(HttpStatus.OK).body(consultationDTO);
//		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
