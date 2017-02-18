import java.util.*;
import java.io.*;
import java.nio.file.*;
class padrao{
    public static void main(String [] args)throws IOException{
        //entrando com arquivo de texto
        byte[] entrada = Files.readAllBytes(Paths.get("input/8.input"));
        //armazenar para comparar
        ArrayList <String> enumerados = new ArrayList <String>();

        for(int a = 0; a < entrada.length; a++){
            boolean encontrou = false;

            for(int i = 0; i < enumerados.size(); i++)
                if(enumerados.get(i).equals("" + (char)entrada[a]) || (char)entrada[a] == '\n')
                    encontrou = true;
            if(!encontrou)
                enumerados.add("" + (char)entrada[a]);
        }
        //imprimindo os padrões encontrados na entrada de texto
        System.out.println("Conteúdo do Arquivo de Entrada: " + new String(entrada, "UTF-8"));
        for(int a = 0; a < entrada.length; a++)
            for(int i = 0; i < enumerados.size(); i++)
                if(enumerados.get(i).equals("" + (char)entrada[a]))
                    System.out.println(enumerados.get(i) + ": " + i);
    }
}