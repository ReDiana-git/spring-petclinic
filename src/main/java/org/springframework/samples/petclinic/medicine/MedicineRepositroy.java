package org.springframework.samples.petclinic.medicine;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.payment.PaymentEntity;
import org.springframework.transaction.annotation.Transactional;

public interface MedicineRepositroy extends Repository<MedicineEntity,String> {
	void save(MedicineEntity medicineEntity);

	MedicineEntity findById(String medicineId);
	@Modifying
	@Query("UPDATE MedicineEntity medicineEntity SET medicineEntity.medicines = :medicines WHERE medicineEntity.id = :medicineId")
	void updateMedicines(@Param("medicineId") String medicineId, @Param("medicines") String medicines);
}
