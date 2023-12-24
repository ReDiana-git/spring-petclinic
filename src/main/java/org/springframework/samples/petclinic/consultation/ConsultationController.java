package org.springframework.samples.petclinic.consultation;

import com.google.gson.Gson;
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
		CheckConsultationDTO checkConsultationDTO = consultationService.checkConsultation(recordId);
		return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(checkConsultationDTO));
	}

	@PostMapping("/appoint/updateConsultation")
	public ResponseEntity<?> updateConsultation(@RequestBody UpdateConsultationDTO updateConsultationDTO){
		consultationService.updateConsultation(updateConsultationDTO);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
