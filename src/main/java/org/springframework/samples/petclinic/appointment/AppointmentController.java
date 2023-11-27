package org.springframework.samples.petclinic.appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.owner.OwnerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;

@Controller
public class AppointmentController {
	@Autowired
	AppointRepository repository;
	HashMap<String,AppointmentContext> contextMap = new HashMap<>();
	@PostMapping("/appointment/create")
	public ResponseEntity<?> createAppointment(@RequestBody AppointmentEntity appointmentEntity){
		AppointmentContext context = new AppointmentContext(appointmentEntity);
		context.handleAppointment();
		context.setState(new ConsultationState());
		contextMap.put(appointmentEntity.getId(),context);
//		repository.save(appointmentEntity);

		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	@PostMapping("/appointment/consultation")
	public ResponseEntity<?> consultationAppointment(@RequestBody AppointmentEntity appointmentEntity){

//		repository.save(appointmentEntity);

		return ResponseEntity.status(HttpStatus.OK).build();
	}


}
