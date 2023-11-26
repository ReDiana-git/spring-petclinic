package org.springframework.samples.petclinic.appointment;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
public class AppointServiceTest {

	@Mock
	private AppointRepository appointRepository;
}
