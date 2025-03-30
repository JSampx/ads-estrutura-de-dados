public class ListaEncadeada {
    /*
    Estrutura de dados para armazenar uma lista de objetos palavras em nós. Contém o nó com a palavra.
     */
    private No<Palavra> primeiroNo;
    private No<Palavra> ultimoNo;
    private int tamanho = 0;


    public void adicionar(No no) {

        if (this.tamanho == 0) {
            this.primeiroNo = no;
        } else {
            this.ultimoNo.setProximoNo(no);
        }
        this.ultimoNo = no;
        this.tamanho++;
    }

    public void adicionarNoInicio(Palavra p) {

    }

    public String imprimirLista() {
        String text = "";
        while (primeiroNo.getProximoNo() != null) {
            text += primeiroNo.getProximoNo().toString();
        }
        return text;
    }

    public int buscarNo(Palavra palavra) {

        No<Palavra> noAtual = this.primeiroNo;
        int pos = 0;

        while (noAtual != null) {

            if (noAtual.getPalavra().equals(palavra)) {
                return pos;
            }
            pos++;
            noAtual = noAtual.getProximoNo();
        }

        return -1;
    }

    @Override
    public String toString() {

        if (this.tamanho == 0) {
            return "[]";
        }

        StringBuilder builder = new StringBuilder("[");
        // builder.append("ListaEncadeada [inicio=").append(inicio).append("]");

        No<Palavra> atual = this.primeiroNo;
        for (int i = 0; i < this.tamanho - 1; i++) {
            builder.append(atual.getPalavra()).append(",");
            atual = atual.getProximoNo();
        }
        builder.append(atual.getPalavra()).append("]");
        /*
         * builder.append(atual.getElemento()).append(",");
         * while (atual.getProximo() != null) {
         * atual = atual.getProximo();
         * builder.append(atual.getElemento()).append(",");
         * }
         */

        return builder.toString();
    }
}
