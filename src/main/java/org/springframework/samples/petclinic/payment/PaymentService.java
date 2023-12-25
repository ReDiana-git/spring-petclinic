package org.springframework.samples.petclinic.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.medicalRecord.MedicalRecord;
import org.springframework.samples.petclinic.medicalRecord.MedicalRecordRepository;
import org.springframework.samples.petclinic.medicine.MedicineRepositroy;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
	@Autowired
	PaymentRepository paymentRepository;
	@Autowired
	MedicalRecordRepository medicalRecordRepository;
	public void payment(String recordId) {
		MedicalRecord medicalRecord = medicalRecordRepository.findById(recordId);
		PaymentEntity paymentEntity = paymentRepository.findById(medicalRecord.getPaymentId());
		paymentEntity = payMoney(paymentEntity);
		paymentRepository.updatePaymentStatus(paymentEntity.getId(),paymentEntity.getPaymentStatus());
	}

	// 進行付款驗證
	public PaymentEntity payMoney(PaymentEntity paymentEntity){
		paymentEntity.setPaymentStatus(true);
		return paymentEntity;
	}
}
