package in.vineeth;

import java.util.List;
import java.util.Optional;

public interface RFService {

	public FormRegistration registrationsForm(FormRegistration formRegistration) throws FormRegistrationNotFoundException;

	public List<FormRegistration> getRegForm();

	public Optional<FormRegistration> fetchByID(Integer id) throws FormRegistrationNotFoundException;

}
