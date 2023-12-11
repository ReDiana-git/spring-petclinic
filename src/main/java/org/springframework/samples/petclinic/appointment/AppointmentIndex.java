package org.springframework.samples.petclinic.appointment;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.samples.petclinic.model.AppointmentState;

import java.io.Serializable;

@Entity
@Table(name = "appointmentIndex")
public class AppointmentIndex implements Serializable {

	@Id
	@Column(name = "id")
	private String id;

	@Column(name = "owner_id")
	private Integer ownerId;

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
				return AppointmentState.MEDICATION;
		}
		return null;
	}
	@Column(name = "state")
	private String State;

	@Column(name = "pet_id")
	private Integer petId;

	public AppointmentIndex(AppointmentEntity appointmentEntity){
		this.id = appointmentEntity.getId();
		this.ownerId = appointmentEntity.getOwnerId();
		this.petId = appointmentEntity.getPetId();
	}
	public AppointmentIndex(){

	}
}
