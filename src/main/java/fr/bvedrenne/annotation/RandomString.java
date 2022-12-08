package fr.bvedrenne.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.jupiter.api.extension.ExtendWith;

import fr.bvedrenne.extension.RandomStringExtension;

@Target({ ElementType.PARAMETER }) // TODO Add ElementType.FIELD
@Retention(RetentionPolicy.RUNTIME)
@ExtendWith(RandomStringExtension.class)
public @interface RandomString {
	int length() default 10;

	boolean letter() default true;

	boolean number() default true;

	/**
	 * Using this option ignore {@link RandomString#letter()} and
	 * {@link RandomString#number()} to set then to true both.
	 * 
	 * @return Option activation.
	 */
	boolean ascii() default false;

	/**
	 * Using this option ignore {@link RandomString#letter()},
	 * {@link RandomString#number()} and {@link RandomString#ascii()} to set then to
	 * true.
	 * 
	 * @return Option activation.
	 */
	boolean allVisible() default false;
}
