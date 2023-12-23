package org.springframework.samples.petclinic.consultation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.appointment.AppointmentEntity;
import org.springframework.samples.petclinic.medicalRecord.MedicalRecord;
import org.springframework.samples.petclinic.medicalRecord.MedicalRecordRepository;
import org.springframework.samples.petclinic.medicine.MedicineEntity;
import org.springframework.samples.petclinic.medicine.MedicineRepositroy;
import org.springframework.stereotype.Service;

@Service
public class ConsultationService {
	@Autowired
	ConsultationRepository consultationRepository;
	@Autowired
	MedicalRecordRepository medicalRecordRepository;
	@Autowired
	MedicineRepositroy medicineRepositroy;

	public ConsultationDTO checkConsultaion(String recordId) {
		MedicalRecord record = medicalRecordRepository.findById(recordId);
		System.out.println(record.getConsultaionId());
		ConsultationEntity consultation = consultationRepository.findById(record.getConsultaionId());
		System.out.println(consultation.getPrice());
		MedicineEntity medicine = medicineRepositroy.findById(record.getMedicineId());
		return new ConsultationDTO(consultation, record, medicine);
	}
}
