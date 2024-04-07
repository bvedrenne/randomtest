package fr.bvedrenne.extension;

import java.lang.annotation.Annotation;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.util.Arrays;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolver;

/**
 * Super class to create random generator.
 *
 * @param <T> Annotation allowed
 */
public abstract class AbstractRandom<T extends Annotation> implements ParameterResolver {
    private final Class<T> annotation;
    private final Class<?>[] acceptedClass;

    @SuppressWarnings("unchecked")
    AbstractRandom(final Class<?>[] acceptedClass) {
        this.annotation = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
        this.acceptedClass = acceptedClass;
    }

    /**
     * Check if the parameter can be managed by ths class.
     *
     * @param parameterContext Context of the parameter
     * @param extensionContext Context of the extension
     * @return true if the parameter has valid type
     */
    @Override
    public boolean supportsParameter(final ParameterContext parameterContext, final ExtensionContext extensionContext) {
        return parameterContext.isAnnotated(annotation) && validateType(parameterContext.getParameter().getType());
    }

    private boolean validateType(final Class<?> type) {
        return Arrays.stream(this.acceptedClass).anyMatch(x -> x == type);
    }

    /**
     * Do action corresponding to the parameter.
     *
     * @param parameterContext Context of the parameter
     * @param extensionContext Context of the extension
     * @return Corresponding transformation
     */
    @Override
    public Object resolveParameter(final ParameterContext parameterContext, final ExtensionContext extensionContext) {
        return getRandomValue(parameterContext.getParameter(), extensionContext);
    }

    /**
     * Do action corresponding to the parameter.
     *
     * @param parameter        Parameter
     * @param extensionContext Context of the extension
     * @return Corresponding transformation
     */
    protected Object getRandomValue(final Parameter parameter, final ExtensionContext extensionContext) {
        return getRandomValue(parameter.getAnnotation(annotation), extensionContext);
    }

    /**
     * Do action corresponding to the parameter.
     *
     * @param parameter        Class wanted
     * @param extensionContext Context of the extension
     * @return Random value corresponding
     */
    protected Object getRandomValue(final T parameter, final ExtensionContext extensionContext) {
        return null;
    }
}
