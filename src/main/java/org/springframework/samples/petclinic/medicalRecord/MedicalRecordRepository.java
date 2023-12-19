package org.springframework.samples.petclinic.medicalRecord;

import org.springframework.data.jpa.repository.Query;
import org.springframework.samples.petclinic.medicalRecord.MedicalRecord;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;
@org.springframework.stereotype.Repository
public interface MedicalRecordRepository extends Repository<MedicalRecord,String> {
	void save(MedicalRecord index);

	List<MedicalRecord> findByOwnerId(Integer ownerId);

	MedicalRecord findById(String recordId);
}
