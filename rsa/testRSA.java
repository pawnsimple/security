import javax.crypto.Cipher;
import java.security.*;

public class testRSA {
	public static void main( String [] args ){
		KeyPair chave;
		byte[]    textoCript;
		String textoDescript;
		PrivateKey priv;
		PublicKey pub;

		RSA cript = new RSA();
		chave = cript.generateKeyPair();
		priv = chave.getPrivate();
		pub = chave.getPublic();
		textoCript = cript.encrypt("Saida em janeiro",pub);
		System.out.println("Texto Criptografado: \n");
		for (int i=0; i<textoCript.length; i++)
				 System.out.print(textoCript[i]);                     
			System.out.println("\n");  
		textoDescript = cript.decrypt(textoCript,priv);
		System.out.println("\n Texto Descriptografado:\n "+textoDescript);
		

		
		
	
	}

}