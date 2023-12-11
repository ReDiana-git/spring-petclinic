package org.springframework.samples.petclinic.appointment;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface ConsultationRepository extends Repository<ConsultaionEntity,String> {
	void save(ConsultaionEntity consultaionEntity);

	@Query("SELECT consultaionEntity FROM ConsultaionEntity consultaionEntity WHERE consultaionEntity.ownerId = :ownerId")
	@Transactional(readOnly = true)
	List<ConsultaionEntity> findByOwnerId(@Param("ownerId") Integer ownerId);
	@Query("SELECT consultaionEntity FROM ConsultaionEntity consultaionEntity WHERE consultaionEntity.id = :id")
	@Transactional(readOnly = true)
	ConsultaionEntity findById(@Param("id") String id);
}
