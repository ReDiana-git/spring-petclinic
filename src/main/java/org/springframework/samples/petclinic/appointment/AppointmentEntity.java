package org.springframework.samples.petclinic.appointment;

import jakarta.persistence.*;
import org.springframework.samples.petclinic.medicalRecord.MedicalRecord;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "appointments")
public class AppointmentEntity implements Serializable {

	@Id
	@Column(name = "id")
	private String id ;
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
	public LocalDateTime getAppointmentDate() {
		return appointmentDate;
	}
	public AppointmentEntity(MedicalRecord medicalRecord, CreateAppointmentDTO createAppointmentDTO){
		this.id = medicalRecord.getAppointmentId();
		this.appointmentDate = createAppointmentDTO.getAppointmentDate();
	}
	public AppointmentEntity(){

	}
}
