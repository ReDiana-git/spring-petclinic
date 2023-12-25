package org.springframework.samples.petclinic.payment;

import org.springframework.samples.petclinic.medicalRecord.MedicalRecord;
import org.springframework.samples.petclinic.model.BaseRecord;

public class CheckPaymentDTO extends BaseRecord {
	private Integer price;
	public CheckPaymentDTO(PaymentEntity paymentEntity, MedicalRecord record){
		this.price = paymentEntity.getPrice();
		super.setOwnerId(record.getOwnerId());
		super.setPetId(record.getPetId());
		super.setState(record.getState());
	}
}
