public class No<Palavra> {
    /*
    Classe Nó para ser gerenciada na lista encadeada.
     */
    private Palavra palavra;
    private No<Palavra> proximoNo;

    public Palavra getPalavra() {
        return palavra;
    }

    public void setPalavra(Palavra palavra) {
        this.palavra = palavra;
    }

    public No<Palavra> getProximoNo() {
        return proximoNo;
    }

    public void setProximoNo(No<Palavra> proximoNo) {
        this.proximoNo = proximoNo;
    }

    public No(Palavra palavra) {
        this.palavra = palavra;
        this.proximoNo = null;
    }

    public No(Palavra palavra, No<Palavra> proximoNo) {
        this.palavra = palavra;
        this.proximoNo = proximoNo;
    }

    @Override
    public String toString() {
        if (proximoNo != null) {
            return palavra + " -> " + proximoNo;
        } else {
            return (String) palavra;
        }
    }
}
