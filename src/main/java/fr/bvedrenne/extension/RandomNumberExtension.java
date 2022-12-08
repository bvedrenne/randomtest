package fr.bvedrenne.extension;

import java.lang.reflect.Parameter;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Namespace;
import org.junit.jupiter.api.extension.ParameterResolutionException;

import fr.bvedrenne.annotation.RandomNumber;

public class RandomNumberExtension extends AbstractRandom<RandomNumber> {
    RandomNumberExtension() {
        super(new Class<?>[] {int.class, double.class, long.class, boolean.class, Integer.class, Double.class,
                Long.class, Boolean.class});
    }

    protected Object getRandomValue(Parameter parameter, ExtensionContext extensionContext) {
        Class<?> type = parameter.getType();
        RandomNumber randomAnnotation = parameter.getAnnotation(RandomNumber.class);
        java.util.Random random = extensionContext.getRoot().getStore(Namespace.GLOBAL)
                .getOrComputeIfAbsent(java.util.Random.class);
        if (int.class.equals(type) || Integer.class.equals(type)) {
            return random.ints(randomAnnotation.min(), randomAnnotation.max()).findAny().getAsInt();
        }
        if (double.class.equals(type) || Double.class.equals(type)) {
            return random.doubles(randomAnnotation.min(), randomAnnotation.max()).findAny().getAsDouble();
        }
        if (long.class.equals(type) || Long.class.equals(type)) {
            return random.longs(randomAnnotation.min(), randomAnnotation.max()).findAny().getAsLong();
        }
        if (boolean.class.equals(type) || Boolean.class.equals(type)) {
            return random.nextBoolean();
        }
        throw new ParameterResolutionException("No random generator implemented for " + type);
    }
}
