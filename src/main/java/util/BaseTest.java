package util;

import com.github.javafaker.Faker;

import java.util.Locale;

import static config.TestConfig.LOCALE_FOR_TEST;

public class BaseTest {
    public static Faker faker = new Faker(new Locale(LOCALE_FOR_TEST));

}
