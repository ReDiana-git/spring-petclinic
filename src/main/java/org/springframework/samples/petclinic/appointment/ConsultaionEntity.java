package org.springframework.samples.petclinic.appointment;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "consultaion")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class ConsultaionEntity extends AppointmentEntity{

	public ConsultaionEntity() {
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Column(name = "price")
	private Integer price;
//	@Id
//	@Column(name = "id")
//	private String id ;

//	public String getId() {
//		return id;
//	}

//	public Integer getOwnerId() {
//		return ownerId;
//	}
//
//	public Integer getPetId() {
//		return petId;
//	}
//
//	public LocalDateTime getAppointmentDate() {
//		return appointmentDate;
//	}
//
//	public LocalDateTime getCreateTime() {
//		return createTime;
//	}
//
//	public void setId(String id) {
//		this.id = id;
//	}
//
//	public void setOwnerId(Integer ownerId) {
//		this.ownerId = ownerId;
//	}
//
//	public void setPetId(Integer petId) {
//		this.petId = petId;
//	}
//
//	public void setAppointmentDate(LocalDateTime appointmentDate) {
//		this.appointmentDate = appointmentDate;
//	}
//
//	public void setCreateTime(LocalDateTime createTime) {
//		this.createTime = createTime;
//	}

//	@Column(name = "owner_id")
//	private Integer ownerId;
//	@Column(name = "pet_id")
//	private Integer petId;
//	@Column(name = "appointmentdate")
//	private LocalDateTime appointmentDate;
//	@Column(name = "createtime")
//	private LocalDateTime createTime = LocalDateTime.now();
	ConsultaionEntity(AppointmentEntity appointmentEntity){
		super(appointmentEntity);
//		 this.id = appointmentEntity.getId();
//		 this.ownerId = appointmentEntity.getOwnerId();
//		 this.petId=appointmentEntity.getPetId();
//		 this.appointmentDate=appointmentEntity.getAppointmentDate();
//		 this.createTime=appointmentEntity.getCreateTime();
	}
}
