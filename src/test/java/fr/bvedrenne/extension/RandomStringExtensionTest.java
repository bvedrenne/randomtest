package fr.bvedrenne.extension;

import fr.bvedrenne.annotation.RandomString;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.mockito.Mockito;

class RandomStringExtensionTest {
    RandomStringExtension randomNumberExtension = new RandomStringExtension();

    @Test
    void getRandomValueAllVisible() {
        RandomString randomAnnotation = Mockito.mock(RandomString.class);

        Mockito.when(randomAnnotation.length()).thenReturn(10);
        Mockito.when(randomAnnotation.allVisible()).thenReturn(true);

        final Object value = randomNumberExtension.getRandomValue(randomAnnotation, null);

        Assertions.assertInstanceOf(String.class, value);
        Assertions.assertTrue(StringUtils.isAsciiPrintable((String) value));
    }

    @Test
    void getRandomValueAscii() {
        RandomString randomAnnotation = Mockito.mock(RandomString.class);

        Mockito.when(randomAnnotation.length()).thenReturn(10);
        Mockito.when(randomAnnotation.allVisible()).thenReturn(false);
        Mockito.when(randomAnnotation.ascii()).thenReturn(true);

        final Object value = randomNumberExtension.getRandomValue(randomAnnotation, null);

        Assertions.assertInstanceOf(String.class, value);
        Assertions.assertTrue(StringUtils.isAsciiPrintable((String) value));
    }

    @Test
    void getRandomValueAlpha() {
        RandomString randomAnnotation = Mockito.mock(RandomString.class);

        Mockito.when(randomAnnotation.length()).thenReturn(10);
        Mockito.when(randomAnnotation.allVisible()).thenReturn(false);
        Mockito.when(randomAnnotation.ascii()).thenReturn(false);
        Mockito.when(randomAnnotation.letter()).thenReturn(true);
        Mockito.when(randomAnnotation.number()).thenReturn(false);

        final Object value = randomNumberExtension.getRandomValue(randomAnnotation, null);

        Assertions.assertInstanceOf(String.class, value);
        Assertions.assertTrue(StringUtils.isAlpha((String) value));
    }

    @Test
    void getRandomValueNumber() {
        RandomString randomAnnotation = Mockito.mock(RandomString.class);

        Mockito.when(randomAnnotation.length()).thenReturn(10);
        Mockito.when(randomAnnotation.allVisible()).thenReturn(false);
        Mockito.when(randomAnnotation.ascii()).thenReturn(false);
        Mockito.when(randomAnnotation.letter()).thenReturn(false);
        Mockito.when(randomAnnotation.number()).thenReturn(true);

        final Object value = randomNumberExtension.getRandomValue(randomAnnotation, null);

        Assertions.assertInstanceOf(String.class, value);
        Assertions.assertTrue(StringUtils.isNumeric((String) value));
    }

    @Test
    void getRandomValueAlphaNumber() {
        RandomString randomAnnotation = Mockito.mock(RandomString.class);

        Mockito.when(randomAnnotation.length()).thenReturn(10);
        Mockito.when(randomAnnotation.allVisible()).thenReturn(false);
        Mockito.when(randomAnnotation.ascii()).thenReturn(false);
        Mockito.when(randomAnnotation.letter()).thenReturn(true);
        Mockito.when(randomAnnotation.number()).thenReturn(true);

        final Object value = randomNumberExtension.getRandomValue(randomAnnotation, null);

        Assertions.assertInstanceOf(String.class, value);
        Assertions.assertTrue(StringUtils.isAlphanumeric((String) value));
    }

    @Test
    void getRandomValueWithWrongLength() {
        RandomString randomAnnotation = Mockito.mock(RandomString.class);

        Mockito.when(randomAnnotation.length()).thenReturn(-10);

        Assertions.assertThrows(ParameterResolutionException.class,
                () -> randomNumberExtension.getRandomValue(randomAnnotation, null), "Invalid length");
    }
}