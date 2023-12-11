package org.springframework.samples.petclinic.appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@CrossOrigin
public class AppointmentController {
	@Autowired
	AppointRepository appointRepository;
	@Autowired
	ConsultationRepository consultationRepository;
	@Autowired
	AppointmentService appointmentService;
	@Autowired
	AppointmentIndexRepository indexRepository;

	@PostMapping("/appointment/create")
	public ResponseEntity<?> createAppointment(@RequestBody AppointmentEntity appointmentEntity){
		appointmentService.saveAppointment(appointmentEntity);

		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@PostMapping("/appointment/getAppointments")
	public ResponseEntity<?> getAppointment(@RequestBody String OwnerId){

		List<?> appointmentEntities = appointmentService.getAppointments(Integer.valueOf(OwnerId));
		return ResponseEntity.status(HttpStatus.OK).body(appointmentEntities);
	}

	@PostMapping("/appointment/getPayment")
	public ResponseEntity<?> getPaymentInfo(@RequestBody String ownerId){
		List<ConsultaionEntity> consultaionEntity = consultationRepository.findByOwnerId(Integer.valueOf(ownerId));

		return ResponseEntity.status(HttpStatus.CREATED).body(consultaionEntity);
	}

}
