package org.springframework.samples.petclinic.consultation;

import jakarta.persistence.*;
import org.springframework.samples.petclinic.medicalRecord.MedicalRecord;

import java.io.Serializable;

@Entity
@Table(name = "consultation")
public class ConsultationEntity implements Serializable {

	public ConsultationEntity() {
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getId() {
		return id;
	}

	@Id
	@Column(name = "id")
	private String id;
	@Column(name = "price")
	private Integer price;

	public ConsultationEntity(MedicalRecord medicalRecord){
		this.id = medicalRecord.getConsultaionId();
	}
}
