import java.io.*;
import java.nio.file.*;


class main{
	public static void main(String [] args)throws IOException{
		 byte[] text = Files.readAllBytes(Paths.get("../input/7.input"));
         byte[] entrada = text.clone();
         certificado c = new certificado(entrada);
         c.gerarCertificado();
        
	} 

}