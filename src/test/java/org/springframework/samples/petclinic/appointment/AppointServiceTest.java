package org.springframework.samples.petclinic.appointment;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class AppointServiceTest {

	@Mock
	private AppointmentRepository appointmentRepository;
}
