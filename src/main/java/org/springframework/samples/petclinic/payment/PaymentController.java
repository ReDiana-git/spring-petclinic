package org.springframework.samples.petclinic.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.appointment.AppointmentRepository;
import org.springframework.samples.petclinic.consultation.ConsultationRepository;
import org.springframework.samples.petclinic.medicalRecord.MedicalRecordRepository;
import org.springframework.samples.petclinic.medicine.MedicineRepositroy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@CrossOrigin
public class PaymentController {
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
	PaymentService paymentService;

	// 對某單進行付款
	@PostMapping("/appointment/payment")
	public ResponseEntity<?> payment(@RequestBody String recordId){
		paymentService.payment(recordId);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
