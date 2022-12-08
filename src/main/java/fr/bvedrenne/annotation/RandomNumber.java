package fr.bvedrenne.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.jupiter.api.extension.ExtendWith;

import fr.bvedrenne.extension.RandomNumberExtension;

@Target({ ElementType.PARAMETER }) // TODO Add ElementType.FIELD
@Retention(RetentionPolicy.RUNTIME)
@ExtendWith(RandomNumberExtension.class)
public @interface RandomNumber {
	// TODO Use value corresponding to random type
	int min() default Integer.MIN_VALUE;

	int max() default Integer.MAX_VALUE;
}
