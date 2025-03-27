public class ListaEncadeada{
    /*
    Estrutura de dados para armazenar uma lista de objetos palavras em nós. Contém o nó com a palavra.
     */
    private No<Palavra> primeiroNo;
    private No<Palavra> ultimoNo;
    private int tamanho = 0;

    public void adicionar(No p){

        if (this.tamanho == 0){
            this.primeiroNo = p;
        }else {
            this.ultimoNo.setProximoNo(p);
        }
        this.ultimoNo = p;
        this.tamanho++;
    }

    public void adicionarNoInicio(Palavra p){

    }

}
