package org.springframework.samples.petclinic.medicine;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface MedicineRepositroy extends Repository<MedicineEntity,String> {
	void save(MedicineEntity medicineEntity);

	MedicineEntity findById(String medicineId);
}
