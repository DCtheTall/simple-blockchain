// Implementation of cryptography methods for blockchain.

import java.security.MessageDigest;

public class Crypto {
    public static String sha256(String input) {
        try {
            MessageDigest sha = MessageDigest.getInstance("SHA-256");
            byte[] hash = sha.digest(input.getBytes("UTF-8"));
            StringBuffer hashBuffer = new StringBuffer();
            for (int i = 0; i < hash.length; ++i) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) {
                    hashBuffer.append('0');
                }
                hashBuffer.append(hex);
            }
            return hashBuffer.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        System.out.println(sha256("Hello, world!"));
    }
}
