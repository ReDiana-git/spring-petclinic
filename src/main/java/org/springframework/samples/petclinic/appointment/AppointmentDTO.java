package org.springframework.samples.petclinic.appointment;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.OwnerRepository;
import org.springframework.samples.petclinic.owner.Pet;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Entity
public class AppointmentDTO {

	@Id
	private String id;
	private String ownerName;
	private String petName;
	private LocalDateTime appointmentDate;

	public String getId() {
		return id;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public String getPetName() {
		return petName;
	}

	public LocalDateTime getAppointmentDate() {
		return appointmentDate;
	}

	public LocalDateTime getAppointmentCreateDate() {
		return appointmentCreateDate;
	}

	private LocalDateTime appointmentCreateDate;
	public AppointmentDTO(){

	}
//	public AppointmentModel DTO2appointment(){
//		AppointmentModel appointmentModel = new AppointmentModel(id,ownerName,petName,appointmentDate,appointmentCreateDate);
//
//		return appointmentModel;
//	}
}
