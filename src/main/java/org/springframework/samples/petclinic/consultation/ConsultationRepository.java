package org.springframework.samples.petclinic.consultation;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.payment.PaymentEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface ConsultationRepository extends Repository<ConsultationEntity,String> {
	void save(ConsultationEntity consultationEntity);
	ConsultationEntity findById(@Param("id") String id);

	@Modifying
	@Query("UPDATE ConsultationEntity consultationEntity SET consultationEntity.symptom = :symptom WHERE consultationEntity.id = :consultaionId")
	void updateSymptom(@Param("consultaionId") String consultaionId, @Param("symptom") String symptom);
}
