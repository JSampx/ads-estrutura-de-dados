import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.function.Predicate;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//        DocumentIO doc = new DocumentIO();
//        System.out.println(doc.readFile("filename.txt"));

        String texto = DocumentIO.readFile("filename.txt");
        //System.out.println(texto);

        String[] palavras = Arrays.asList(texto.split("\\W+")).toArray(new String[0]); //retira todos os caracteres que não são palavras e adiciona a uma lista

        Set<Palavra> conjunto = new TreeSet<>();
        for (String p : palavras){
            if (!Objects.equals(p, "")) {
                Palavra p1 = new Palavra(p);
                conjunto.add(p1);
            }
        }
        List<Palavra> listaPalavras = new ArrayList<>(conjunto);

//        TreeMap<String, TreeSet<Integer>> indice = new TreeMap<>();
        try (BufferedReader leitor = new BufferedReader(new FileReader("filename.txt"))) {
            String linha;
            int numeroLinha = 1;
            while ((linha = leitor.readLine()) != null) {
                // Quebrar linha em palavras, removendo pontuação e convertendo para minúsculas
                String[] palavras2 = linha.toLowerCase().split("[^a-zA-ZÀ-ÿ0-9]+");
                //System.out.println(Arrays.toString(palavras2));

                for (String palavra : palavras2) {
                    Palavra p = new Palavra(palavra);
                    if (conjunto.contains(p)) {
                        for (int i = 0; i<listaPalavras.size(); i++){
                            int x = 0;
                            if (listaPalavras.get(i).equals(p)){
                                listaPalavras.get(i).setOcorrencia(numeroLinha);

                            }
                        }
                    }
                }
                numeroLinha++;
            }

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        System.out.println(listaPalavras);
//        // Exibir índice remissivo
//        List<String> st = new ArrayList<>();
//        for (Map.Entry<String, TreeSet<Integer>> entrada : indice.entrySet()) {
//            String linhaFormatada = (entrada.getKey() + "  " + entrada.getValue());
//            st.add(linhaFormatada);
//        }
//
//        DocumentIO.writeFile("resultado.txt", st);

    }

}
