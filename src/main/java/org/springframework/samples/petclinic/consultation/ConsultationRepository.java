package org.springframework.samples.petclinic.consultation;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface ConsultationRepository extends Repository<ConsultationEntity,String> {
	void save(ConsultationEntity consultationEntity);
	ConsultationEntity findById(@Param("id") String id);


}
