package org.springframework.samples.petclinic.medicine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.appointment.AppointmentRepository;
import org.springframework.samples.petclinic.consultation.ConsultationRepository;
import org.springframework.samples.petclinic.medicalRecord.MedicalRecord;
import org.springframework.samples.petclinic.medicalRecord.MedicalRecordRepository;
import org.springframework.samples.petclinic.payment.PaymentRepository;
import org.springframework.stereotype.Service;

@Service
public class MedicineSerive {
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
	public GetMedicineDTO getMedicine(String recordId){
		MedicalRecord medicalRecord = medicalRecordRepository.findById(recordId);
		MedicineEntity medicineEntity = medicineRepositroy.findById(medicalRecord.getMedicineId());
		GetMedicineDTO getMedicineDto = new GetMedicineDTO();
		getMedicineDto.setMedecines(medicineEntity.getMedicines());
		return getMedicineDto;
	}
}
