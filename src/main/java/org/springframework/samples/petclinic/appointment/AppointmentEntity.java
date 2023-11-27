package org.springframework.samples.petclinic.appointment;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "appointments")
public class AppointmentEntity implements Serializable {

	@Id
	@Column(name = "id")
	private String id = UUID.randomUUID().toString();;
	@Column(name = "owner_id")
	private Integer ownerId;
	@Column(name = "pet_id")
	private Integer petId;
	@Column(name = "appointmentdate")
	private LocalDateTime appointmentDate;
	public LocalDateTime getCreateTime() {
		return createTime;
	}
	@Column(name = "createtime")
	private LocalDateTime createTime = LocalDateTime.now();

	public String getId() {
		return id;
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public Integer getPetId() {
		return petId;
	}

	public LocalDateTime getAppointmentDate() {
		return appointmentDate;
	}
	public AppointmentEntity(){

	}

}
