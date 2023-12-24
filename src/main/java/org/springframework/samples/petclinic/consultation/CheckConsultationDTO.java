package org.springframework.samples.petclinic.consultation;

import org.springframework.samples.petclinic.medicalRecord.MedicalRecord;
import org.springframework.samples.petclinic.medicine.MedicineEntity;
import org.springframework.samples.petclinic.model.BaseRecord;

public class CheckConsultationDTO extends BaseRecord {
	// 客戶為看病狀況
	// 會回覆客戶
	private Integer price;
	public CheckConsultationDTO(ConsultationEntity consultationEntity, MedicalRecord record, MedicineEntity medicineEntity){
		super.ownerId = record.getOwnerId();
		super.petId = record.getPetId();
		this.price = consultationEntity.getPrice();
	}
}
