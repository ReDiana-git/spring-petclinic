package org.springframework.samples.petclinic.payment;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.samples.petclinic.appointment.CreateAppointmentDTO;
import org.springframework.samples.petclinic.medicalRecord.MedicalRecord;

import java.io.Serializable;

@Entity
@Table(name = "payment")
public class PaymentEntity implements Serializable {
	@Id
	@Column(name = "id")
	private String id;
	public PaymentEntity(MedicalRecord medicalRecord){
		this.id = medicalRecord.getPaymentId();
	}
	public PaymentEntity(){

	}
}
