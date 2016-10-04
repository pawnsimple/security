public class VigenereCipher {
    public static void main(String[] args) {
        String chave = "abcd";
        String textooBranco = "<!-- html-header type=current begin -->";
        String criptografado = encrypt(textooBranco, chave);
        System.out.println(criptografado);
        System.out.println(decrypt(criptografado, chave));
    }
 
    static String encrypt(String texto, final String chave) {
        String saidaTexto = "";
        for (int i = 0, j = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            saidaTexto += (char)((c + chave.charAt(j) ) % 256);
            j = ++j % chave.length();
        }
        return saidaTexto;
    }
 
    static String decrypt(String texto, final String chave) {
        String saidaTexto = "";
        for (int i = 0, j = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            saidaTexto += (char)((c - chave.charAt(j) + 256) % 256 );
            j = ++j % chave.length();
        }
        return saidaTexto;
    }
}