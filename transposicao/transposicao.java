import java.io.*;
import java.nio.file.*;
public class transposicao{
    public byte[] entrada;
    public int linhas, colunas;
    public String enderecoCrip = "outputs/saida_crip.txt";
    public String enderecoDescript = "outputs/saida_descrip.txt";
    public transposicao(){}
    public transposicao(byte[] v, int chave) throws IOException{
        this.colunas = chave;
        this.linhas = v.length/this.colunas;
        this.entrada = v;
    }
    public byte[][] criarMat(byte[] matriz){
        if((matriz.length % this.colunas) != 0) this.linhas++;
        byte[][] aux = new byte[this.colunas][this.linhas];
        for(int l = 0, b = 0; l < this.linhas; l++)
            for(int c = 0; c < this.colunas && b < matriz.length; c++, b++)
                aux[c][l] = matriz[b]; 
               //variavel b percorre o vetor de entrada, para colocar os valores na matriz
        return aux;
    }
    public byte[] transporMat(byte[][] matrizTrans) {
    //recebe a matriz, escreve a transporMat em um array de bytes, retornando esse array.
        byte[] aux = new byte[this.linhas*this.colunas];
        for(int c = 0, a = 0; c < this.colunas; c++)
            for(int l = 0; l < this.linhas && a < aux.length; l++, a++)
            //fazendo a transporMat, primeiro escreve as linhas.
                aux[a] = matrizTrans[c][l];
        return aux;
    }
    public void cript() throws IOException{
        FileOutputStream w = new FileOutputStream(new File(enderecoCrip));
        this.entrada = transporMat(criarMat(this.entrada));
        w.write(this.entrada);
        w.close();
    }
    public void descript(int chave, byte[] keyTurnLine) throws IOException{
        FileOutputStream w = new FileOutputStream(new File(enderecoDescript));
        this.linhas = chave;
        // pra descriptografar, é o processo contrario a chave vira as linhas.
        this.colunas = keyTurnLine.length/this.linhas;
        w.write(transporMat(criarMat(keyTurnLine)));
        //Primeiro cria a matriz, dps faz a transporMat da transpota, que é a propria matriz original
        w.close();
    }
    
    
}
