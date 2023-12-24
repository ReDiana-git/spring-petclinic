package org.springframework.samples.petclinic.consultation;

public class UpdateConsultationDTO {
    public String getMedicines(){
		return medicines;
	};

    public String getRecordId() {
		return RecordId;
	}

	private String RecordId;
	private String medicines;
}
