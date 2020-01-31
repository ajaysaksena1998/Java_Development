package upes.techteam.validator;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidatorClass implements ConstraintValidator<Validate,String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		boolean result=value.equals("sksingh@ddn.upes.ac.in");
		return result;
	}

	
}
