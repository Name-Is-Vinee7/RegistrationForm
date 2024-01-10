package in.vineeth;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class FormRegistration {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty(message = "username shouldn't be null")
	private String username;

	@NotEmpty(message = "password shouldn't be null")
	private String password;

	@Email(message = "invalid email address")
	private String email;

	@Digits(message = "number should contain 10 digits", fraction = 0, integer = 10)
	private String number;

}
