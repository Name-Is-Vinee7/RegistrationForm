package in.vineeth;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.vineeth.response.ResponseHandler;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class RFController {

	@Autowired
	private RFService rservice;

	@GetMapping("/welcome")
	public String Welcome() {

		return "welcome to security";
	}
	
	@GetMapping("/getData")
	public String getMessage() {
		return "Accessed by HTTPS protocal";
	}

	@GetMapping("/all")
	public List<FormRegistration> getRegForm() {
		return rservice.getRegForm();
	}

	@PostMapping("/registration")
	public ResponseEntity<Object> registrationForm(@RequestBody @Valid FormRegistration formRegistration) throws FormRegistrationNotFoundException {

		return ResponseHandler.responseBuilder("success", HttpStatus.OK, rservice.registrationsForm(formRegistration));

	}
	
	@GetMapping("/all/{id}")
	public Optional<FormRegistration> fetchById(@PathVariable("id") Integer id) throws FormRegistrationNotFoundException {
		return rservice.fetchByID(id);
	}
}
