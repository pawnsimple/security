import java.io.*;
import java.nio.file.*;

class main{
    public static void main(String [] args)throws IOException{
        byte[] text = Files.readAllBytes(Paths.get("../input/7.input"));
        byte[] entrada = text.clone();
        int ktransp = 13;
        
        transposicao t = new transposicao(entrada, ktransp);
        t.cript();
        t.descript(ktransp, Files.readAllBytes(Paths.get("outputs/saida_crip.txt")));
    }
}
