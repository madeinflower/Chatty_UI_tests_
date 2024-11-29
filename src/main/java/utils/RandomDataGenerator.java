package utils;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomDataGenerator {

    public static String generateRandomName(int maxLength) {
        Random random = new Random();
        int length = random.nextInt(maxLength) + 3;
        StringBuilder name = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            char letter = (char) ('a' + random.nextInt(26));
            name.append(letter);
        }
        return name.toString();
    }

    public static String generateRandomSurname(int maxLength) {
        Random random = new Random();
        int length = random.nextInt(maxLength) + 3;
        StringBuilder surname = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            char letter = (char) ('a' + random.nextInt(26));
            surname.append(letter);
        }
        return surname.toString();
    }

    public static String generateRandomPhoneNumber() {
        long randomNumber = ThreadLocalRandom.current().nextLong(10000000000L, 100000000000L);
        return String.valueOf(randomNumber);
    }

    public static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder result = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            result.append(characters.charAt(index));
        }

        return result.toString();
    }
}
