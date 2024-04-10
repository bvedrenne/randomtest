package fr.bvedrenne.extension;

import fr.bvedrenne.annotation.RandomString;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;

public class RandomStringExtension extends AbstractRandom<RandomString> {
    RandomStringExtension() {
        super(new Class<?>[]{String.class});
    }

    /**
     * Return random string.
     *
     * @param randomAnnotation Class wanted
     * @param extensionContext Context of the extension
     * @return String
     */
    protected Object getRandomValue(final RandomString randomAnnotation, final ExtensionContext extensionContext) {
        int length = randomAnnotation.length();
        if (length <= 0) {
            throw new ParameterResolutionException("Invalid length");
        }
        if (randomAnnotation.allVisible()) {
            return RandomStringUtils.randomPrint(length);
        }
        if (randomAnnotation.ascii()) {
            return RandomStringUtils.randomAscii(length);
        }
        return RandomStringUtils.random(length, randomAnnotation.letter(), randomAnnotation.number());
    }
}
