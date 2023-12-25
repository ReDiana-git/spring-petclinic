package org.springframework.samples.petclinic.medicine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.medicalRecord.MedicalRecord;
import org.springframework.samples.petclinic.medicalRecord.MedicalRecordRepository;
import org.springframework.stereotype.Service;

@Service
public class MedicineSerive {
	@Autowired
	MedicalRecordRepository medicalRecordRepository;
	@Autowired
	MedicineRepositroy medicineRepositroy;
	public GetMedicineDTO getMedicine(String recordId){
		MedicalRecord medicalRecord = medicalRecordRepository.findById(recordId);
		MedicineEntity medicineEntity = medicineRepositroy.findById(medicalRecord.getMedicineId());
		GetMedicineDTO getMedicineDto = new GetMedicineDTO();
		getMedicineDto.setMedecines(medicineEntity.getMedicines());
		return getMedicineDto;
	}
}
