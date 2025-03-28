import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//        DocumentIO doc = new DocumentIO();
//        System.out.println(doc.readFile("filename.txt"));
        final int POSICOES = 90; // Considera o fator de carga 0,7 na função de espalhamento para 26 caracteres do alfabeto. fc = [37/26] = 0.7

        ListaEncadeada[] vetorDeListas = new ListaEncadeada[POSICOES];

        /*
        Palavra palavra1 = new Palavra("Alberto");
        Palavra palavra2 = new Palavra("Alice");


        No no1 = new No(palavra1);
        No no2 = new No(palavra2);

        no1.setProximoNo(no2);
        System.out.println(no1);*/

        String texto = DocumentIO.readFile("filename.txt");
        //System.out.println(texto);


        List<String> palavras = Arrays.asList(texto.split("\\W+")); //retira todos os caracteres que não são palavras e adiciona a uma lista
//        for (String p : palavras){
//            System.out.println(p);
//        }
        for (int i = 1; i < palavras.size(); i++) {
            No no = new No();
            ListaEncadeada lista = new ListaEncadeada();
            if (!Objects.equals(palavras.get(i), "")) {
                Palavra pal = new Palavra(palavras.get(i));
                no.setPalavra(pal);
                int pos = Hash.funcHash(pal);
                lista.adicionar(no);
                if (vetorDeListas[pos] == null) {
                    vetorDeListas[pos] = lista;
                }else vetorDeListas[pos].adicionar(no);
            }
            System.out.println(vetorDeListas[i]);
        }
    }


}


