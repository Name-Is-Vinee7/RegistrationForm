package in.vineeth;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RFServiceIMPL implements RFService {

	@Autowired
	private RFRepository rRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public FormRegistration registrationsForm(FormRegistration formRegistration)
			throws FormRegistrationNotFoundException {
		if(rRepository.findByusername(formRegistration.getUsername()) != null) { throw new FormRegistrationNotFoundException("user is already registered");}
		if (formRegistration.getUsername() == "" && formRegistration.getUsername() == null) {
			throw new FormRegistrationNotFoundException("please enter valid username");
		}
		if (formRegistration.getPassword() == "" && formRegistration.getPassword() == null) {
			throw new FormRegistrationNotFoundException("please enter valid password");
		}
		if (formRegistration.getEmail() == "" && formRegistration.getEmail() == null) {
			throw new FormRegistrationNotFoundException("please enter valid email");
		}
		if (formRegistration.getNumber() == "" && formRegistration.getNumber() == null) {
			throw new FormRegistrationNotFoundException("please enter valid number");
		}
		formRegistration.setPassword(passwordEncoder.encode(formRegistration.getPassword()));
		System.out.println(formRegistration.getUsername());
		System.out.println(formRegistration.getPassword());
		System.out.println(formRegistration.getEmail());
		System.out.println(formRegistration.getNumber());
		return rRepository.save(formRegistration);
	}

	@Override
	public List<FormRegistration> getRegForm() {
		return rRepository.findAll();
	}

	@Override
	public Optional<FormRegistration> fetchByID(Integer id) throws FormRegistrationNotFoundException {
		Optional<FormRegistration> rf = rRepository.findById(id);
		if (!rf.isPresent()) {
			throw new FormRegistrationNotFoundException("id is not available");
		}
		return Optional.of(rf.get());
	}

}
