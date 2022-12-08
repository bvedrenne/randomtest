package fr.bvedrenne.extension;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;

import fr.bvedrenne.annotation.RandomString;

public class RandomStringExtension extends AbstractRandom<RandomString> {
	RandomStringExtension() {
		super(new Class<?>[] {String.class});
	}

	protected Object getRandomValue(RandomString randomAnnotation, ExtensionContext extensionContext) {
		if(randomAnnotation.allVisible()) {
			return RandomStringUtils.randomPrint(randomAnnotation.length());
		}
		if(randomAnnotation.ascii()) {
			return RandomStringUtils.randomAscii(randomAnnotation.length());
		}
		return RandomStringUtils.random(randomAnnotation.length(), randomAnnotation.letter(),
				randomAnnotation.number());
	}
}
