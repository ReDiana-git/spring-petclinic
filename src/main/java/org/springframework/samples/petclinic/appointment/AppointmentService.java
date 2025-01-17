package org.springframework.samples.petclinic.appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.consultation.CheckConsultationDTO;
import org.springframework.samples.petclinic.consultation.ConsultationEntity;
import org.springframework.samples.petclinic.consultation.ConsultationRepository;
import org.springframework.samples.petclinic.medicalRecord.MedicalRecord;
import org.springframework.samples.petclinic.medicalRecord.MedicalRecordRepository;
import org.springframework.samples.petclinic.medicine.CheckMedicineDTO;
import org.springframework.samples.petclinic.medicine.MedicineEntity;
import org.springframework.samples.petclinic.medicine.MedicineRepositroy;
import org.springframework.samples.petclinic.model.BaseRecord;
import org.springframework.samples.petclinic.payment.CheckPaymentDTO;
import org.springframework.samples.petclinic.payment.PaymentEntity;
import org.springframework.samples.petclinic.payment.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentService {
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

	//客戶建立訂單
	public void createAppointment(CreateAppointmentDTO createAppointmentDTO){
		MedicalRecord medicalRecord = new MedicalRecord(createAppointmentDTO);
		medicalRecordRepository.save(medicalRecord);
		AppointmentEntity appointment = new AppointmentEntity(medicalRecord, createAppointmentDTO);
		appointmentRepository.save(appointment);
		ConsultationEntity consultaion = new ConsultationEntity(medicalRecord);
		consultationRepository.save(consultaion);
		PaymentEntity payment = new PaymentEntity(medicalRecord);
		paymentRepository.save(payment);
		MedicineEntity medicine = new MedicineEntity(medicalRecord);
		medicineRepositroy.save(medicine);
	}
	public List<?> getAppointments(Integer owner_id){
		List<MedicalRecord> MedicalRecords = medicalRecordRepository.findByOwnerId(owner_id);
		List<BaseRecord> records = new ArrayList<>();
		for(MedicalRecord record:MedicalRecords){
			System.out.println(record.getAppointmentId());
			switch (record.getState()){
				case INIT :
					CheckAppointmentDTO checkAppointmentDTO = new CheckAppointmentDTO(appointmentRepository.findById(record.getAppointmentId()), record);
					records.add(checkAppointmentDTO);
					break;
				case CONSULTAION:
					CheckConsultationDTO checkConsultationDTO = new CheckConsultationDTO(consultationRepository.findById(record.getConsultaionId()), record, medicineRepositroy.findById(record.getMedicineId()));
					records.add(checkConsultationDTO);
					break;
				case PAYMENT:
					CheckPaymentDTO checkPaymentDTO = new CheckPaymentDTO(paymentRepository.findById(record.getPaymentId()), record);
					records.add(checkPaymentDTO);
					break;
				case MEDICINE:
					CheckMedicineDTO checkMedicineDTO = new CheckMedicineDTO(paymentRepository.findById(record.getPaymentId()), record);
					records.add(checkMedicineDTO);
					break;
			}
		}
		return records;
	}
}
