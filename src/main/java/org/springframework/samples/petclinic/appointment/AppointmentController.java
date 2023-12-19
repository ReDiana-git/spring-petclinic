package org.springframework.samples.petclinic.appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.consultation.ConsultationRepository;
import org.springframework.samples.petclinic.medicalRecord.MedicalRecordRepository;
import org.springframework.samples.petclinic.medicine.MedicineRepositroy;
import org.springframework.samples.petclinic.payment.PaymentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
@CrossOrigin
public class AppointmentController {
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
	AppointmentService appointmentService;

	@PostMapping("/appointment/createAppointments")
	public ResponseEntity<?> createAppointment(@RequestBody CreateAppointmentDTO createAppointMentDTO){
		appointmentService.createAppointment(createAppointMentDTO);

		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@PostMapping("/appointment/getAppointments")
	public ResponseEntity<?> getAppointment(@RequestBody String OwnerId){

		List<?> appointmentEntities = appointmentService.getAppointments(Integer.valueOf(OwnerId));
		return ResponseEntity.status(HttpStatus.OK).body(appointmentEntities);
	}

}
