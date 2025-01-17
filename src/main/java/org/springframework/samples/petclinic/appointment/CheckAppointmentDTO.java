package org.springframework.samples.petclinic.appointment;

import org.springframework.samples.petclinic.medicalRecord.MedicalRecord;
import org.springframework.samples.petclinic.model.AppointmentState;
import org.springframework.samples.petclinic.model.BaseRecord;

import java.io.Serializable;
import java.time.LocalDateTime;

public class CheckAppointmentDTO extends BaseRecord {
	public String getRecordId() {
		return recordId;
	}

	public String getAppointmentId() {
		return appointmentId;
	}

	public LocalDateTime getAppointmentDate() {
		return appointmentDate;
	}

	private String recordId;
	private String appointmentId;
	private LocalDateTime appointmentDate;

	public CheckAppointmentDTO(AppointmentEntity appointmentEntity, MedicalRecord record){
		this.recordId = record.getId();
		this.appointmentId = record.getAppointmentId();
		this.appointmentDate = appointmentEntity.getAppointmentDate();
		super.setPetId(record.getPetId());
		super.setOwnerId(record.getOwnerId());
		super.setState(record.getState());
	}
}
