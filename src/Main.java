import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String texto = DocumentIO.readFile("filename.txt");
        String[] palavras = Arrays.asList(texto.split("\\W+")).toArray(new String[0]); //retira todos os caracteres que não são palavras e adiciona a uma lista

        Set<Palavra> conjunto = new TreeSet<>();
        for (String p : palavras){
            if (!Objects.equals(p, "")) {
                Palavra p1 = new Palavra(p);
                conjunto.add(p1);
            }
        }
        List<Palavra> listaPalavras = new ArrayList<>(conjunto);
        try (BufferedReader leitor = new BufferedReader(new FileReader("filename.txt"))) {
            String linha;
            int numeroLinha = 1;
            while ((linha = leitor.readLine()) != null) {
                String[] palavras2 = linha.toLowerCase().split("[^a-zA-ZÀ-ÿ0-9]+");

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

        List<String> z = new ArrayList<>();
        for (Palavra p : listaPalavras){
            z.add(p.toString());
        }
        DocumentIO.writeFile("resultado.txt", z);

    }

}
