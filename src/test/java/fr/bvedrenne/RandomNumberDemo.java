package fr.bvedrenne;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.bvedrenne.annotation.RandomNumber;
import fr.bvedrenne.annotation.RandomString;

public class RandomNumberDemo {

	RandomNumberDemo(@RandomNumber int randomNumber, @RandomString String randomString) {
		// use random number in constructor
		System.out.println(randomNumber);
		System.out.println(randomString);
	}

	@BeforeEach
	void beforeEach(@RandomNumber int randomNumber, @RandomString String randomString) {
		// use random number in @BeforeEach method
		System.out.println(randomNumber);
		System.out.println(randomString);
	}

	@Test
	void test(@RandomNumber int randomNumber, @RandomString String randomString,
			@RandomString(ascii = true) String randomString2, @RandomString(allVisible = true) String randomString3) {
		// use random number in test method
		System.out.println(randomNumber);
		System.out.println(randomString);
		System.out.println(randomString2);
		System.out.println(randomString3);
	}

}
