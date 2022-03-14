import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Crypto {

    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/ECB/PKCS5Padding";

    public String encryptMessage(byte[] message, byte[] keyBytes) throws InvalidKeyException, NoSuchAlgorithmException,
            NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException {
        // Create Instance of Cipher which take type of algo used as argument

        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        SecretKey secretKey = new SecretKeySpec(keyBytes, ALGORITHM);

        // initiate the algorithm
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] msg = cipher.doFinal(message);
        return new String(msg);
    }

    // Decrypt Message
    public String decryptMessage(byte[] encMsg, byte[] keyByte) throws NoSuchAlgorithmException, NoSuchPaddingException,
            InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        SecretKey secretKey = new SecretKeySpec(keyByte, ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] clearMsg = cipher.doFinal(encMsg);
        return new String(clearMsg);
    }

    public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException,
            BadPaddingException, IllegalBlockSizeException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Encryption Key");
        String encKey = sc.nextLine();

        System.out.println("Enter your message");
        String message = sc.nextLine();
        Crypto obj = new Crypto();

        // Encrypt message
        String encMsg = obj.encryptMessage(message.getBytes(), encKey.getBytes());

        // Decrypt message
        String decMsg = obj.decryptMessage(encMsg.getBytes(), encKey.getBytes());
        System.out.println("Original Message: " + message);
        System.out.println("Encrypted Message: " + encMsg);
        System.out.println("Decrypted Message: " + decMsg);
        sc.close();

    }

}

