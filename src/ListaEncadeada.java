import java.util.EmptyStackException;

public class ListaEncadeada {
    /*
    Estrutura de dados para armazenar uma lista de objetos palavras em nós. Contém o nó com a palavra.
     */
    private Palavra primeiroNo;
    private Palavra ultimoNo;
    private int tamanho = 0;


    public void adicionar(Palavra p) {

        if (this.tamanho == 0) {
            this.primeiroNo = p;
        } else {
            this.ultimoNo.setProxPalavra(p);
        }
        this.ultimoNo = p;
        this.tamanho++;
    }


    public Palavra buscar(String palavra) {
        Palavra atual = this.primeiroNo;
        while (atual != null) {
            if (atual.getPalavra().equals(palavra)) {
                return atual;
            }
            atual = atual.getProxPalavra();
        }
        return null; // Palavra não encontrada
    }


    public Palavra buscaNo(int posicao) {

        if (this.tamanho == 0) {
            throw new IllegalArgumentException("NAO_EXISTE");
        }

        Palavra noAtual = this.primeiroNo;
        for (int i = 0; i < posicao; i++) {
            noAtual = noAtual.getProxPalavra();
        }

        return noAtual;
    }

    public int getTamanho() {
        return tamanho;
    }

    @Override
    public String toString() {

        if (this.tamanho == 0) {
            return "[]";
        }

        StringBuilder builder = new StringBuilder("[");


        Palavra atual = this.primeiroNo;
        for (int i = 0; i < this.tamanho - 1; i++) {
            builder.append(atual.getPalavra()).append(",");
            atual = atual.getProxPalavra();
        }
        builder.append(atual.getPalavra()).append("]");
        return builder.toString();
    }
}
