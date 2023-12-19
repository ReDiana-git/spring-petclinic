package org.springframework.samples.petclinic.consultation;

import org.springframework.samples.petclinic.medicalRecord.MedicalRecord;
import org.springframework.samples.petclinic.medicine.MedicineEntity;
import org.springframework.samples.petclinic.model.BaseRecord;

public class ConsultationDTO extends BaseRecord {

	private String medicines;
	public ConsultationDTO(ConsultationEntity consultationEntity, MedicalRecord record, MedicineEntity medicineEntity){
		super.ownerId = record.getOwnerId();
		super.petId = record.getPetId();
		this.medicines = medicineEntity.getMedicines();
	}
}
