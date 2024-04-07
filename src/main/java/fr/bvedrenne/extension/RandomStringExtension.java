package fr.bvedrenne.extension;

import fr.bvedrenne.annotation.RandomString;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.extension.ExtensionContext;

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
        if (randomAnnotation.allVisible()) {
            return RandomStringUtils.randomPrint(randomAnnotation.length());
        }
        if (randomAnnotation.ascii()) {
            return RandomStringUtils.randomAscii(randomAnnotation.length());
        }
        return RandomStringUtils.random(randomAnnotation.length(), randomAnnotation.letter(),
                randomAnnotation.number());
    }
}
