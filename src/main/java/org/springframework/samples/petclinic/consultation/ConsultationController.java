package org.springframework.samples.petclinic.consultation;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.appointment.*;
import org.springframework.samples.petclinic.medicalRecord.MedicalRecordRepository;
import org.springframework.samples.petclinic.medicine.MedicineRepositroy;
import org.springframework.samples.petclinic.payment.PaymentRepository;
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
	PaymentRepository paymentRepository;
	@Autowired
	MedicineRepositroy medicineRepositroy;
	@Autowired
	ConsultationService consultationService;

	//給醫生查看病歷
	@PostMapping("/appointment/checkConsultation")
	public ResponseEntity<?> checkConsultation(@RequestBody String recordId){
		CheckConsultationDTO checkConsultationDTO = consultationService.checkConsultation(recordId);
		return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(checkConsultationDTO));
	}

	//給醫生更新病歷
	@PostMapping("/appointment/updateConsultation")
	public ResponseEntity<?> updateConsultation(@RequestBody UpdateConsultationDTO updateConsultationDTO){
		consultationService.updateConsultation(updateConsultationDTO);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
