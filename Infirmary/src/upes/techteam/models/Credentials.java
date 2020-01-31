package upes.techteam.models;

import javax.validation.constraints.NotNull;

import upes.techteam.validator.Password;
import upes.techteam.validator.Validate;

public class Credentials {

	@NotNull(message = "This field cannot be blank")
	@Validate
	String email;
	@NotNull(message = "This field cannot be blank")
	@Password
	String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Credentials [email=" + email + ", password=" + password + "]";
	}
}
