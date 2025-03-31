import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        final int POSICOES = 46; // Tamanho da Tabela Hash
        final String ARQUIVO_TEXTO = "filename.txt";
        ListaEncadeada[] vetorDeListas = new ListaEncadeada[POSICOES];

        try (BufferedReader leitor = new BufferedReader(new FileReader(ARQUIVO_TEXTO))) {
            String linha;
            int numeroLinha = 1;

            while ((linha = leitor.readLine()) != null) {
                // Divide a linha em palavras
                String[] palavras = linha.toLowerCase().split("[^a-zA-ZÀ-ÿ0-9]+");

                for (String palavra : palavras) {
                    if (!palavra.isEmpty()) {
                        Palavra pal = new Palavra(palavra);
                        int pos = Hash.funcHash(pal);

                        // Se a lista na posição `pos` ainda não foi criada, cria uma nova
                        if (vetorDeListas[pos] == null) {
                            vetorDeListas[pos] = new ListaEncadeada();
                        }

                        // Verifica se a palavra já está na lista encadeada
                        Palavra palavraExistente = vetorDeListas[pos].buscar(palavra);

                        if (palavraExistente == null) {
                            pal.setOcorrencia(numeroLinha);
                            vetorDeListas[pos].adicionar(pal);
                        } else {
                            palavraExistente.setOcorrencia(numeroLinha);
                        }
                    }
                }
                numeroLinha++;
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        // Exibir o índice remissivo ordenado
        for (ListaEncadeada lista : vetorDeListas) {
            if (lista != null) {
                for (int i = 0; i < lista.getTamanho(); i++) {
                    System.out.println(lista.buscaNo(i));
                }
            }
        }
    }
}
