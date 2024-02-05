import java.security.SecureRandom;
import java.util.Random;
public class Main {
            private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
            private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            private static final String DIGITS = "0123456789";
            private static final String SPECIAL_CHARACTERS = "!@#$%^&*()_+[]{}|;:,.<>?";

            public static void main(String[] args) {
                int length = 12; //  u can Change the desired length of the password
                boolean useLowercase = true;
                boolean useUppercase = true;
                boolean useDigits = true;
                boolean useSpecialCharacters = true;

                String password = generatePassword(length, useLowercase, useUppercase, useDigits, useSpecialCharacters);
                System.out.println("Generated Password for u : " + password);
            }

            public static String generatePassword(int length, boolean useLowercase, boolean useUppercase, boolean useDigits, boolean useSpecialCharacters) {
                StringBuilder validChars = new StringBuilder();
                Random random = new SecureRandom();

                if (useLowercase) {
                    validChars.append(LOWERCASE);
                }
                if (useUppercase) {
                    validChars.append(UPPERCASE);
                }
                if (useDigits) {
                    validChars.append(DIGITS);
                }
                if (useSpecialCharacters) {
                    validChars.append(SPECIAL_CHARACTERS);
                }

                if (validChars.length() == 0) {
                    throw new IllegalArgumentException("At least one character type should be selected.");
                }

                StringBuilder password = new StringBuilder(length);
                for (int i = 0; i < length; i++) {
                    int randomIndex = random.nextInt(validChars.length());
                    password.append(validChars.charAt(randomIndex));
                }

                return password.toString();
            }
}

