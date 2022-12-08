package fr.bvedrenne.extension;

import fr.bvedrenne.annotation.RandomNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.mockito.Mockito;

import java.lang.reflect.Parameter;
import java.util.Random;
import java.util.stream.IntStream;

class RandomNumberExtensionTest {
    RandomNumberExtension randomNumberExtension = new RandomNumberExtension();

    public void test(@RandomNumber(min = 1, max = 2) int integer, @RandomNumber(min = 1, max = 2) Integer intValue) {
    }

    public void test(@RandomNumber(min = 1, max = 2) double doubleValue,
                     @RandomNumber(min = 1, max = 2) Double doubleObject) {
    }

    public void test(@RandomNumber(min = 1, max = 2) long longValue,
                     @RandomNumber(min = 1, max = 2) Long longObject) {
    }

    public void test(@RandomNumber boolean booleanValue, @RandomNumber Boolean booleanObject) {
    }

    @Test
    @DisplayName("Check that RandomNumber return integer")
    void getRandomValueInt() throws NoSuchMethodException {
        final Parameter parameter =
                RandomNumberExtensionTest.class.getDeclaredMethod("test", int.class, Integer.class).getParameters()[0];
        final ExtensionContext extensionContext = Mockito.mock(ExtensionContext.class);
        final ExtensionContext.Store store = Mockito.mock(ExtensionContext.Store.class);
        final Random random = new Random(1);

        Mockito.when(extensionContext.getRoot()).thenReturn(extensionContext);
        Mockito.when(extensionContext.getStore(ExtensionContext.Namespace.GLOBAL)).thenReturn(store);
        Mockito.when(store.getOrComputeIfAbsent(java.util.Random.class)).thenReturn(random);

        Assertions.assertEquals(1, randomNumberExtension.getRandomValue(parameter, extensionContext));
    }

    @Test
    @DisplayName("Check that RandomNumber return double")
    void getRandomValueDouble() throws NoSuchMethodException {
        final Parameter parameter =
                RandomNumberExtensionTest.class.getDeclaredMethod("test", double.class, Double.class)
                        .getParameters()[0];
        final ExtensionContext extensionContext = Mockito.mock(ExtensionContext.class);
        final ExtensionContext.Store store = Mockito.mock(ExtensionContext.Store.class);
        final Random random = new Random(1);

        Mockito.when(extensionContext.getRoot()).thenReturn(extensionContext);
        Mockito.when(extensionContext.getStore(ExtensionContext.Namespace.GLOBAL)).thenReturn(store);
        Mockito.when(store.getOrComputeIfAbsent(java.util.Random.class)).thenReturn(random);

        Assertions.assertEquals(1.7308781907032909, randomNumberExtension.getRandomValue(parameter, extensionContext));
    }

    @Test
    @DisplayName("Check that RandomNumber return long")
    void getRandomValueLong() throws NoSuchMethodException {
        final Parameter parameter =
                RandomNumberExtensionTest.class.getDeclaredMethod("test", long.class, Long.class).getParameters()[0];
        final ExtensionContext extensionContext = Mockito.mock(ExtensionContext.class);
        final ExtensionContext.Store store = Mockito.mock(ExtensionContext.Store.class);
        final Random random = new Random(1);

        Mockito.when(extensionContext.getRoot()).thenReturn(extensionContext);
        Mockito.when(extensionContext.getStore(ExtensionContext.Namespace.GLOBAL)).thenReturn(store);
        Mockito.when(store.getOrComputeIfAbsent(java.util.Random.class)).thenReturn(random);

        Assertions.assertEquals(1L, randomNumberExtension.getRandomValue(parameter, extensionContext));
    }

    @Test
    @DisplayName("Check that RandomNumber return boolean")
    void getRandomValue() throws NoSuchMethodException {
        final Parameter parameter =
                RandomNumberExtensionTest.class.getDeclaredMethod("test", boolean.class, Boolean.class)
                        .getParameters()[0];
        final ExtensionContext extensionContext = Mockito.mock(ExtensionContext.class);
        final ExtensionContext.Store store = Mockito.mock(ExtensionContext.Store.class);
        final Random random = new Random(1);

        Mockito.when(extensionContext.getRoot()).thenReturn(extensionContext);
        Mockito.when(extensionContext.getStore(ExtensionContext.Namespace.GLOBAL)).thenReturn(store);
        Mockito.when(store.getOrComputeIfAbsent(java.util.Random.class)).thenReturn(random);

        Assertions.assertTrue((boolean) randomNumberExtension.getRandomValue(parameter, extensionContext));
    }

    @Test
    @DisplayName("Check that RandomNumber return integer")
    void getRandomValueIntegerObject() throws NoSuchMethodException {
        final Parameter parameter =
                RandomNumberExtensionTest.class.getDeclaredMethod("test", int.class, Integer.class).getParameters()[1];
        final ExtensionContext extensionContext = Mockito.mock(ExtensionContext.class);
        final ExtensionContext.Store store = Mockito.mock(ExtensionContext.Store.class);
        final Random random = new Random(1);

        Mockito.when(extensionContext.getRoot()).thenReturn(extensionContext);
        Mockito.when(extensionContext.getStore(ExtensionContext.Namespace.GLOBAL)).thenReturn(store);
        Mockito.when(store.getOrComputeIfAbsent(java.util.Random.class)).thenReturn(random);

        Assertions.assertEquals(1, randomNumberExtension.getRandomValue(parameter, extensionContext));
    }

    @Test
    @DisplayName("Check that RandomNumber return double")
    void getRandomValueDoubleObject() throws NoSuchMethodException {
        final Parameter parameter =
                RandomNumberExtensionTest.class.getDeclaredMethod("test", double.class, Double.class)
                        .getParameters()[1];
        final ExtensionContext extensionContext = Mockito.mock(ExtensionContext.class);
        final ExtensionContext.Store store = Mockito.mock(ExtensionContext.Store.class);
        final Random random = new Random(1);

        Mockito.when(extensionContext.getRoot()).thenReturn(extensionContext);
        Mockito.when(extensionContext.getStore(ExtensionContext.Namespace.GLOBAL)).thenReturn(store);
        Mockito.when(store.getOrComputeIfAbsent(java.util.Random.class)).thenReturn(random);

        Assertions.assertEquals(1.7308781907032909, randomNumberExtension.getRandomValue(parameter, extensionContext));
    }

    @Test
    @DisplayName("Check that RandomNumber return long")
    void getRandomValueLongObject() throws NoSuchMethodException {
        final Parameter parameter =
                RandomNumberExtensionTest.class.getDeclaredMethod("test", long.class, Long.class).getParameters()[1];
        final ExtensionContext extensionContext = Mockito.mock(ExtensionContext.class);
        final ExtensionContext.Store store = Mockito.mock(ExtensionContext.Store.class);
        final Random random = new Random(1);

        Mockito.when(extensionContext.getRoot()).thenReturn(extensionContext);
        Mockito.when(extensionContext.getStore(ExtensionContext.Namespace.GLOBAL)).thenReturn(store);
        Mockito.when(store.getOrComputeIfAbsent(java.util.Random.class)).thenReturn(random);

        Assertions.assertEquals(1L, randomNumberExtension.getRandomValue(parameter, extensionContext));
    }

    @Test
    @DisplayName("Check that RandomNumber return boolean")
    void getRandomValueObject() throws NoSuchMethodException {
        final Parameter parameter =
                RandomNumberExtensionTest.class.getDeclaredMethod("test", boolean.class, Boolean.class)
                        .getParameters()[1];
        final ExtensionContext extensionContext = Mockito.mock(ExtensionContext.class);
        final ExtensionContext.Store store = Mockito.mock(ExtensionContext.Store.class);
        final Random random = new Random(1);

        Mockito.when(extensionContext.getRoot()).thenReturn(extensionContext);
        Mockito.when(extensionContext.getStore(ExtensionContext.Namespace.GLOBAL)).thenReturn(store);
        Mockito.when(store.getOrComputeIfAbsent(java.util.Random.class)).thenReturn(random);

        Assertions.assertTrue((boolean) randomNumberExtension.getRandomValue(parameter, extensionContext));
    }
}