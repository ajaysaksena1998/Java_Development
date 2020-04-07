package upes.techteam.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordClass implements ConstraintValidator<Password,String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		boolean result=value.equals("upes@12345");
		return result;
	}
}
