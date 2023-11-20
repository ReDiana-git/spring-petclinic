package org.springframework.samples.petclinic.appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.TestDTO;
import org.springframework.samples.petclinic.owner.OwnerRepository;
import org.springframework.stereotype.Service;

@Service
public class AppointService {


	private AppointRepository repository;
	private OwnerRepository ownerRepository;

	public AppointService(AppointRepository repository, OwnerRepository ownerRepository){
		this.repository = repository;
		this.ownerRepository = ownerRepository;
	}
	public AppointService(){

	}
	public AppointmentModel saveAppointment(AppointmentModel appointmentModel){
		repository.insert(appointmentModel);
		return appointmentModel;
	}
	public void saveAppointment(TestDTO test){
		AppointmentModel model = new AppointmentModel();
		model.setId(test.str);
		repository.insert(model);
	}
	public AppointmentModel DTO2Model(AppointmentDTO dto){
		AppointmentModel model = new AppointmentModel();

		return model;
	}
}
