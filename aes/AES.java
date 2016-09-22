import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec; 


public class AES {
    /**
     * Retorna uma nova chave secreta AES.
     * @return uma chave secreta AES
     */
  	static String IV = "G1c7zp9e32Fs4qMx"; //16

    public static SecretKey generateKey(){
        KeyGenerator keyGenerator = null;
        try {
            keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return keyGenerator.generateKey();
    }

    /**
     * Retorna um AES-Encriptado array de bytes dado um texto e uma chave secreta. 
     * @param plaintext texto a ser encriptado
     * @param key chave AES 
     * @return ciphertext
     */
    public static byte[] encrypt(String plaintext, SecretKey key){
        byte[] ciphertext = null;
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key,new IvParameterSpec(IV.getBytes("UTF-8")));
           	ciphertext = cipher.doFinal(plaintext.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ciphertext;
    }

    /**
     * Retorna um texto dado uma string encriptado com AES, e uma chave secreta.
     * @param ciphertext um array de bytes encriptado com AES
     * @param key uma chave secreta 
     * @return plaintext
     */
    public static String decrypt(byte[] ciphertext, SecretKey key){
        byte[] plaintext = null;
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key,new IvParameterSpec(IV.getBytes("UTF-8")));
            plaintext = cipher.doFinal(ciphertext);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new String(plaintext);
    }
}