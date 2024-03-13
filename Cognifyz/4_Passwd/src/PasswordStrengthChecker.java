import java.util.Scanner;

public class PasswordStrengthChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your password:");
        String password = scanner.nextLine();

        int length = password.length();
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        for (int i = 0; i < length; i++) {
            char ch = password.charAt(i);
            if (Character.isUpperCase(ch)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(ch)) {
                hasLowercase = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            } else {
                hasSpecialChar = true;
            }
        }

        int strengthScore = 0;

        if (length >= 8) {
            strengthScore++;
        }
        if (hasUppercase) {
            strengthScore++;
        }
        if (hasLowercase) {
            strengthScore++;
        }
        if (hasDigit) {
            strengthScore++;
        }
        if (hasSpecialChar) {
            strengthScore++;
        }

        System.out.println("Password Strength Analysis:");

        if (strengthScore >= 5) {
            System.out.println("Very Strong");
        } else if (strengthScore == 4) {
            System.out.println("Strong");
        } else if (strengthScore == 3) {
            System.out.println("Moderate");
        } else if (strengthScore == 2) {
            System.out.println("Weak");
        } else {
            System.out.println("Very Weak");
        }

        scanner.close();
    }
}
