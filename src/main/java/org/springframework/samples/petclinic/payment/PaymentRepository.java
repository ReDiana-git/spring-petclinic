package org.springframework.samples.petclinic.payment;

import org.springframework.data.repository.Repository;

public interface PaymentRepository extends Repository<PaymentEntity,String> {
	void save(PaymentEntity paymentEntity);
}
