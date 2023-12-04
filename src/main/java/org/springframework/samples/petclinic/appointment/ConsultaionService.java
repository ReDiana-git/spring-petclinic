package org.springframework.samples.petclinic.appointment;

import org.springframework.stereotype.Service;

@Service
public class ConsultaionService {
	public static ConsultaionEntity countPrice(AppointmentEntity appointmentEntity) {
		ConsultaionEntity consultaionEntity = new ConsultaionEntity(appointmentEntity);
		consultaionEntity.setPrice(150);
		return consultaionEntity;
	}
}
