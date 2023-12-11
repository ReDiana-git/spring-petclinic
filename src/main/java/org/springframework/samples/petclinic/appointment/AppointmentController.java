package org.springframework.samples.petclinic.appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class AppointmentController {
	@Autowired
	AppointRepository appointRepository;
	@Autowired
	ConsultationRepository consultationRepository;
	@Autowired
	AppointmentService appointmentService;
	@Autowired
	AppointmentIndexRepository indexRepository;

//	HashMap<String,AppointmentContext> contextMap = new HashMap<>();
	@PostMapping("/appointment/create")
	public ResponseEntity<?> createAppointment(@RequestBody AppointmentEntity appointmentEntity){
//		AppointmentContext context = new AppointmentContext(appointmentEntity);
//		context.handleAppointment();
//		context.setState(new ConsultationState());
//		contextMap.put(appointmentEntity.getId(),context);
//		appointRepository.save(appointmentEntity);
		appointmentService.saveAppointment(appointmentEntity);

		return ResponseEntity.status(HttpStatus.CREATED).build();
	}


	@PostMapping("/appointment/getAppointments")
	public ResponseEntity<?> getAppointment(@RequestBody String OwnerId){

		List<AppointmentEntity> appointmentEntities = new ArrayList<>();
		appointmentService.getAppointmentState(Integer.getInteger(OwnerId));
		return ResponseEntity.status(HttpStatus.OK).body(appointmentEntities);
	}

	@PostMapping("/appointment/consultation")
	public ResponseEntity<?> consultationAppointment(@RequestBody String petId){

//		repository.save(appointmentEntity);
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

	@PostMapping("/appointment/getPayment")
	public ResponseEntity<?> getPaymentInfo(@RequestBody String ownerId){
		List<ConsultaionEntity> consultaionEntity = consultationRepository.findByOwnerId(Integer.valueOf(ownerId));

		return ResponseEntity.status(HttpStatus.CREATED).body(consultaionEntity);
	}


}
