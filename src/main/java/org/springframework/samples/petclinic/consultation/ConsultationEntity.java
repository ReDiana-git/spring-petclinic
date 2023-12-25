package org.springframework.samples.petclinic.consultation;

import jakarta.persistence.*;
import org.springframework.samples.petclinic.medicalRecord.MedicalRecord;

import java.io.Serializable;

@Entity
@Table(name = "consultation")
public class ConsultationEntity implements Serializable {

	public ConsultationEntity() {
	}

	public String  getSymptom() {
		return symptom;
	}

	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}

	public String getId() {
		return id;
	}

	@Id
	@Column(name = "id")
	private String id;
	@Column(name = "symptom")
	private String symptom;

	public ConsultationEntity(MedicalRecord medicalRecord){
		this.id = medicalRecord.getConsultaionId();
	}
}
