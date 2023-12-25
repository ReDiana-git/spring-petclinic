package org.springframework.samples.petclinic.consultation;

import org.springframework.beans.factory.annotation.Autowired;
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
		ConsultationEntity consultation = consultationRepository.findById(record.getConsultaionId());
//		consultation.setSymptom((int)(Math.random()*1000) + 1);
	}
}
