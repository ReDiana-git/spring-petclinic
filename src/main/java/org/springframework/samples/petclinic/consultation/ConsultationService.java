package org.springframework.samples.petclinic.consultation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.appointment.AppointmentRepository;
import org.springframework.samples.petclinic.medicalRecord.MedicalRecord;
import org.springframework.samples.petclinic.medicalRecord.MedicalRecordRepository;
import org.springframework.samples.petclinic.medicine.MedicineEntity;
import org.springframework.samples.petclinic.medicine.MedicineRepositroy;
import org.springframework.samples.petclinic.payment.PaymentEntity;
import org.springframework.samples.petclinic.payment.PaymentRepository;
import org.springframework.stereotype.Service;

@Service
public class ConsultationService {
	@Autowired
	AppointmentRepository appointmentRepository;
	@Autowired
	MedicalRecordRepository medicalRecordRepository;
	@Autowired
	ConsultationRepository consultationRepository;
	@Autowired
	PaymentRepository paymentRepository;
	@Autowired
	MedicineRepositroy medicineRepositroy;

	public CheckConsultationDTO checkConsultation(String recordId) {
		MedicalRecord record = medicalRecordRepository.findById(recordId);
		ConsultationEntity consultation = consultationRepository.findById(record.getConsultaionId());
		MedicineEntity medicine = medicineRepositroy.findById(record.getMedicineId());
		return new CheckConsultationDTO(consultation, record, medicine);
	}

	public void updateConsultation(UpdateConsultationDTO updateConsultationDTO) {
		MedicalRecord record = medicalRecordRepository.findById(updateConsultationDTO.getRecordId());
		MedicineEntity medicine = medicineRepositroy.findById(record.getMedicineId());
		medicine.setMedicines(updateConsultationDTO.getMedicines());
		medicineRepositroy.updateMedicines(record.getMedicineId(), medicine.getMedicines());
		ConsultationEntity consultation = consultationRepository.findById(record.getConsultaionId());
		consultation.setSymptom(updateConsultationDTO.getSymptom());
		consultationRepository.updateSymptom(record.getConsultaionId(), consultation.getSymptom());
		paymentRepository.updatePayment(record.getPaymentId(), (int)(Math.random()*1000) + 1);
	}
}
