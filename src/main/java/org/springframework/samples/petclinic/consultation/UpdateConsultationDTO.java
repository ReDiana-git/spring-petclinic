package org.springframework.samples.petclinic.consultation;

public class UpdateConsultationDTO {
    public String getMedicines(){
		return medicines;
	};

    public String getRecordId() {
		return RecordId;
	}
	public String getSymptom(){
		return symptom;
	}
	private String RecordId;
	private String medicines;
	private String symptom;
}
