import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Palavra implements Comparator<Palavra> {
/* Classe Palavra para armazenar as ocorrências do texto fornecido. Terá dois atributos: a palavra
(string) e a lista das ocorrências dessa palavra no texto (Lista Encadeada);*/


    //Atributos
    private String palavra;
    private List<Integer> ocorrencia = new ArrayList<>();
    private Palavra proxPalavra;

    //Construtor com parâmetros
    public Palavra(String palavra) {
        this.palavra = palavra;
    }


    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public List<Integer> getOcorrencia() {
        System.out.println(ocorrencia);
        return ocorrencia;
    }

    public void setOcorrencia(Integer ocorrencia) {
        this.ocorrencia.add(ocorrencia);
    }


    public Palavra getProxPalavra() {
        return proxPalavra;
    }

    public void setProxPalavra(Palavra proxPalavra) {
        this.proxPalavra = proxPalavra;
    }

    @Override
    public int compare(Palavra p1, Palavra p2) {
        return p1.getPalavra().compareTo(p2.getPalavra());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Palavra palavra1 = (Palavra) o;
        return palavra.equals(palavra1.palavra);
    }

    @Override
    public int hashCode() {
        return palavra.hashCode();
    }

    @Override
    public String toString() {

        return palavra + " " + ocorrencia;
    }

}

