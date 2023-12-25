package org.springframework.samples.petclinic.medicine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.medicalRecord.MedicalRecordRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@CrossOrigin
public class MedicineController {

	@Autowired
	MedicineSerive medicineSerive;
	@Autowired
	MedicalRecordRepository medicalRecordRepository;
	@Autowired
	MedicineRepositroy medicineRepositroy;
	@PostMapping("/appoint/getMedicine")
	public ResponseEntity<?> getMedicine(@RequestBody String recordId){
		GetMedicineDTO getMedicineDTO = medicineSerive.getMedicine(recordId);
		return ResponseEntity.status(HttpStatus.OK).body(getMedicineDTO);
	}
}
