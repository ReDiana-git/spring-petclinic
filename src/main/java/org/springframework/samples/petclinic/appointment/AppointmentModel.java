package org.springframework.samples.petclinic.appointment;

import com.mongodb.lang.Nullable;
import jakarta.persistence.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.Pet;

import java.time.LocalDateTime;

@Document(collection = "appointment")
public class AppointmentModel {

	public void setId(String id) {
		this.id = id;
	}

	@Id
	public String getId() {
		return id;
	}


	public Owner getOwner() {
		return owner;
	}

	public Pet getPet() {
		return pet;
	}

	public LocalDateTime getAppointmentDate() {
		return appointmentDate;
	}

	public LocalDateTime getAppointmentCreateDate() {
		return appointmentCreateDate;
	}
	public AppointmentModel(){

	}
	public AppointmentModel(String id, Owner owner, Pet pet, LocalDateTime appointmentDate, LocalDateTime appointmentCreateDate) {
		this.id = id;
		this.owner = owner;
		this.pet = pet;
		this.appointmentDate = appointmentDate;
		this.appointmentCreateDate = appointmentCreateDate;
	}

	private String id;
	@OneToOne
	@Nullable
	private Owner owner;
	@OneToOne
	@Nullable
	private Pet pet;
	@Nullable
	private LocalDateTime appointmentDate;
	@Nullable
	private LocalDateTime appointmentCreateDate;

}
