import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//        DocumentIO doc = new DocumentIO();
//        System.out.println(doc.readFile("filename.txt"));

        String texto = DocumentIO.readFile("filename.txt");
        //System.out.println(texto);

        String[] palavras = Arrays.asList(texto.split("\\W+")).toArray(new String[0]); //retira todos os caracteres que não são palavras e adiciona a uma lista
        Set<String> conjunto = new TreeSet<>();
        Collections.addAll(conjunto, palavras);
        conjunto.remove("");
        int tamanhoSet = conjunto.size();
        List<Palavra> listaPalavras = new ArrayList<Palavra>();
        for (String p : conjunto) {
            Palavra p1 = new Palavra(p);
            p1.setOcorrencia(1);
            listaPalavras.add(p1);
        }
        System.out.println(conjunto);
        System.out.println(listaPalavras);

        TreeMap<String, TreeSet<Integer>> indice = new TreeMap<>();
        try (BufferedReader leitor = new BufferedReader(new FileReader("filename.txt"))) {
            String linha;
            int numeroLinha = 1;
            while ((linha = leitor.readLine()) != null) {
                // Quebrar linha em palavras, removendo pontuação e convertendo para minúsculas
                String[] palavras2 = linha.toLowerCase().split("[^a-zA-ZÀ-ÿ0-9]+");

                for (String palavra : palavras2) {
                    if (!palavra.isEmpty()) { // Evita inserir strings vazias
                        indice.putIfAbsent(palavra, new TreeSet<>());
                        indice.get(palavra).add(numeroLinha);
                    }
                }
                numeroLinha++;
            }

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        // Exibir índice remissivo
        List<String> st = new ArrayList<>();
        for (Map.Entry<String, TreeSet<Integer>> entrada : indice.entrySet()) {
            String linhaFormatada = (entrada.getKey() + "  " + entrada.getValue());
            st.add(linhaFormatada);
        }

        DocumentIO.writeFile("resultado.txt", st);

    }

}
