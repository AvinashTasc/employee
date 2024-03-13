import java.io.*;

public class FileEncryptorDecryptor {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Choose an option:");
            System.out.println("1. Encrypt");
            System.out.println("2. Decrypt");
            int choice = Integer.parseInt(reader.readLine());

            System.out.println("Enter the name or path of the file:");
            String fileName = reader.readLine();

            if (choice == 1) {
                encryptFile(fileName);
                System.out.println("File encrypted successfully.");
            } else if (choice == 2) {
                decryptFile(fileName);
                System.out.println("File decrypted successfully.");
            } else {
                System.out.println("Invalid choice.");
            }
        } catch (IOException e) {
            System.out.println("Error reading input: " + e.getMessage());
        }
    }

    private static void encryptFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter("encrypted_" + fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String encryptedLine = encrypt(line);
                writer.write(encryptedLine);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error encrypting file: " + e.getMessage());
        }
    }

    private static void decryptFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter("decrypted_" + fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String decryptedLine = decrypt(line);
                writer.write(decryptedLine);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error decrypting file: " + e.getMessage());
        }
    }

    private static String encrypt(String text) {
        // Simple encryption algorithm: shift each character by 1
        StringBuilder encryptedText = new StringBuilder();
        for (char c : text.toCharArray()) {
            encryptedText.append((char) (c + 1));
        }
        return encryptedText.toString();
    }

    private static String decrypt(String text) {
        // Simple decryption algorithm: shift each character back by 1
        StringBuilder decryptedText = new StringBuilder();
        for (char c : text.toCharArray()) {
            decryptedText.append((char) (c - 1));
        }
        return decryptedText.toString();
    }
}
