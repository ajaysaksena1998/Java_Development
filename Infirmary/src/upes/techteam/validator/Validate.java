package upes.techteam.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = ValidatorClass.class)
@Target( { ElementType.METHOD, ElementType.FIELD } )
@Retention(RetentionPolicy.RUNTIME)
public @interface Validate {
	
		public String message() default "Invalid Email";
		
		public Class<?>[] groups() default {};
		
		public Class<? extends Payload>[] payload() default {};
}
