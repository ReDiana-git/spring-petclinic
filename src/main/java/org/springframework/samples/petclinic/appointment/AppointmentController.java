package org.springframework.samples.petclinic.appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.model.TestDTO;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.OwnerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AppointmentController {
	@Autowired
	AppointRepository repository;
	@Autowired
	OwnerRepository ownerRepository;
	@PostMapping("/appointment/create")
	public ResponseEntity<?> createAppointment(@RequestBody AppointmentDTO appointmentDTO){
		AppointService service = new AppointService(repository,ownerRepository);
		AppointmentModel appointmentModel = service.DTO2Model(appointmentDTO);

		return ResponseEntity.status(HttpStatus.CREATED).body(appointmentModel);
	}

	@PostMapping("/test")
	public ResponseEntity<?> createTest(@RequestBody TestDTO test){
		AppointService service = new AppointService(repository,ownerRepository);
		service.saveAppointment(test);
		return ResponseEntity.status(HttpStatus.CREATED).body(test);
	}

}
