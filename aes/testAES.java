import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class testAES {
	public static void main( String [] args ){
		SecretKey chave;
		byte[]    textoCript;
		String textoDescript;

		AES cript = new AES();
		chave = cript.generateKey();
		textoCript = cript.encrypt("O navio de carga vai chegar no porto de Madrid em Dezembro,22,2016",chave);
		System.out.println("Texto Criptografado: \n");
		for (int i=0; i<textoCript.length; i++)
				 System.out.print(textoCript[i]);                     
			System.out.println("\n");  
		textoDescript = cript.decrypt(textoCript,chave);
		System.out.println("\n Texto Descriptografado:\n "+textoDescript);
		

		
		
	
	}
}