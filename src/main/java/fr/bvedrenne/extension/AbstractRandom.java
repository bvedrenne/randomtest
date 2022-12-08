package fr.bvedrenne.extension;

import java.lang.annotation.Annotation;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.util.Arrays;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolver;

public abstract class AbstractRandom<T extends Annotation> implements ParameterResolver {
	private Class<T> annotation;
	private Class<?>[] acceptedClass;

	@SuppressWarnings("unchecked")
	AbstractRandom(Class<?>[] acceptedClass) {
		this.annotation = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
		this.acceptedClass = acceptedClass;
	}

	@Override
	public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
		return parameterContext.isAnnotated(annotation) && validateType(parameterContext.getParameter().getType());
	}

	private boolean validateType(Class<?> type) {
		return Arrays.stream(this.acceptedClass).anyMatch(x -> x == type);
	}
	
	@Override
	public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
		return getRandomValue(parameterContext.getParameter(), extensionContext);
	}
	
	protected Object getRandomValue(Parameter parameter, ExtensionContext extensionContext) {
		return getRandomValue(parameter.getAnnotation(annotation), extensionContext);
	}

	protected Object getRandomValue(T parameter, ExtensionContext extensionContext) {
		return null;
	}
}
