package org.springframework.samples.petclinic.medicine;

import org.springframework.samples.petclinic.consultation.ConsultationEntity;
import org.springframework.samples.petclinic.medicalRecord.MedicalRecord;
import org.springframework.samples.petclinic.model.BaseRecord;
import org.springframework.samples.petclinic.payment.PaymentEntity;

public class CheckMedicineDTO extends BaseRecord {
	private Integer price;
	public CheckMedicineDTO(PaymentEntity paymentEntity, MedicalRecord record){
		super.setOwnerId(record.getOwnerId());
		super.setPetId(record.getPetId());
		super.setState(record.getState());
		this.price = paymentEntity.getPrice();
	}
}
