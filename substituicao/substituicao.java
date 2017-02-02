import java.io.*;
import java.nio.file.*;

public class substituicao{
    public byte[] textoCodificado;
    public byte[] chave;
    public substituicao(byte[] v) throws IOException{
        this.textoCodificado = v;
        this.chave = Files.readAllBytes(Paths.get("../keys/key1"));
    }
    public void cript() throws IOException{
        FileOutputStream w = new FileOutputStream(new File("outputs/saida_codificada.txt"));
        for(int u = 0; u < this.textoCodificado.length; u++)
            this.textoCodificado[u] = this.chave[(int)this.textoCodificado[u]];
        w.write(this.textoCodificado);
        w.close();
    }
    public void descript() throws IOException{
        FileOutputStream w = new FileOutputStream(new File("outputs/saida_descodificada.txt"));
        for(int u = 0; u < textoCodificado.length; u++){
            //this.textoCodificado[u] = (byte)this.ascii[Math.abs((int)this.textoCodificado[u])];
        }
        w.write(this.textoCodificado);
        w.close();
    }
}
