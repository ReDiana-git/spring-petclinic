package org.springframework.samples.petclinic.payment;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface PaymentRepository extends Repository<PaymentEntity,String> {
	void save(PaymentEntity paymentEntity);
	PaymentEntity findById(@Param("id") String id);

	@Modifying
	@Query("UPDATE PaymentEntity paymentEntity SET paymentEntity.paymentStatus = :paymentStatus WHERE paymentEntity.id = :paymentId")
	void updatePaymentStatus(@Param("paymentId") String paymentId, @Param("paymentStatus") boolean paymentStatus);

	@Modifying
	@Query("UPDATE PaymentEntity  paymentEntity SET paymentEntity.price = :price WHERE paymentEntity.id = :paymentId")
	void updatePayment(@Param("paymentId") String paymentId, @Param("price") Integer price);
}
