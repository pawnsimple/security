import java.io.*;
import java.nio.file.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.UnsupportedEncodingException;
import javax.crypto.Cipher;
import java.security.*;

public class certificado{
    public byte[] textoSha256;
    public byte[] textoNormal;
    public byte[] textoRSA;
   
    
    
    public certificado(byte[] v) throws IOException{
        this.textoSha256 = v;
        this.textoNormal = v;
        
    }
    public void gerarCertificado() throws IOException{
        FileOutputStream w = new FileOutputStream(new File("certificadoSaida.txt"));
	KeyPair chave;
     	byte[] textoCript;
   	PrivateKey priv;
     	PublicKey pub;
        RSA cript = new RSA();
        chave = cript.generateKeyPair();
        priv = chave.getPrivate();
        pub = chave.getPublic();
        MessageDigest digest = MessageDigest.getInstance("SHA-256");    
	//byte messageDigest = algorithm.digest(hash);

        for(int u = 0; u < this.textoSha256.length; u++){
  	      byte[] text;
	      byte sentenca = textoSha256[u];
              text = digest.digest(sentenca); 
             this.textoSha256[u] = text;
             this.textoRSA[u] = cript.encrypt(textoSha256[u],pub); 
           }
        w.write(this.textoNormal);
        w.write(this.textoSha256);
        w.write(this.textoRSA);
        w.write(this.pub);
        w.close();
    }
   
	
                   
     
}
