package org.springframework.samples.petclinic.medicalRecord;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.samples.petclinic.appointment.CreateAppointmentDTO;
import org.springframework.samples.petclinic.model.AppointmentState;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "medicalrecord")
public class MedicalRecord implements Serializable {

	@Id
	@Column(name = "id")
	private String id = UUID.randomUUID().toString();

	@Column(name = "owner_id")
	private Integer ownerId;
	@Column(name = "state")
	private String State;

	@Column(name = "pet_id")
	private Integer petId;
	@Column(name = "appointment_id")
	private String appointmentId = UUID.randomUUID().toString();
	@Column(name = "consultation_id")
	private String consultaionId = UUID.randomUUID().toString();
	@Column(name = "payment_id")
	private String paymentId = UUID.randomUUID().toString();
	@Column(name = "medicine_id")
	private String medicineId = UUID.randomUUID().toString();

	public String getId() {
		return id;
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public Integer getPetId() {
		return petId;
	}

	public AppointmentState getState(){
		switch(State){
			case "init":
				return AppointmentState.INIT;
			case "consultation":
				return AppointmentState.CONSULTAION;
			case "payment":
				return AppointmentState.PAYMENT;
			case "medication":
				return AppointmentState.MEDICINE;
		}
		return null;
	}
	public String getAppointmentId() {
		return appointmentId;
	}

	public String getConsultaionId() {
		return consultaionId;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public String getMedicineId() {
		return medicineId;
	}

	public MedicalRecord(CreateAppointmentDTO dto) {
		this.ownerId = dto.getOwnerId();
		this.petId = dto.getPetId();
		this.State = "init";
	}

	public MedicalRecord(){

	}
}
