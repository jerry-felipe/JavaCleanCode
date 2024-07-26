package algorithms;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import javax.crypto.Cipher;

public class AsymmetricTutorial {

    public static void main(String[] args) throws Exception {
        // Generate a new RSA key pair
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        KeyPair pair = keyGen.generateKeyPair();
        PublicKey publicKey = pair.getPublic();
        PrivateKey privateKey = pair.getPrivate();

        // Convert keys to string
        String publicKeyString = Base64.getEncoder().encodeToString(publicKey.getEncoded());
        String privateKeyString = Base64.getEncoder().encodeToString(privateKey.getEncoded());

        // Call the encryptText method
        encryptText(publicKeyString, "Hello from Java", "encryptedData.dat");

        // Call the decryptData method and print the result on the screen
        System.out.println("Decrypted message: " + decryptData(privateKeyString, "encryptedData.dat"));
    }

    // Method to encrypt a text and save it to a specific file using an RSA algorithm public key
    public static void encryptText(String publicKeyString, String text, String fileName) throws Exception {
        // Convert the text to an array of bytes
        byte[] dataToEncrypt = text.getBytes("UTF8");

        // Convert the public key string to a PublicKey object
        byte[] publicBytes = Base64.getDecoder().decode(publicKeyString);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(keySpec);

        // Encrypt the data
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedData = cipher.doFinal(dataToEncrypt);

        // Save the encrypted data to a file
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            fos.write(encryptedData);
        }

        System.out.println("Data has been encrypted");
    }

    // Method to decrypt the data within a specific file using an RSA algorithm private key
    public static String decryptData(String privateKeyString, String fileName) throws Exception {
        // Read the encrypted bytes from the file
        byte[] dataToDecrypt = Files.readAllBytes(Paths.get(fileName));

        // Convert the private key string to a PrivateKey object
        byte[] privateBytes = Base64.getDecoder().decode(privateKeyString);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);

        // Decrypt the data
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedData = cipher.doFinal(dataToDecrypt);

        // Get the string value from the decrypted data byte array
        return new String(decryptedData, "UTF8");
    }
}
