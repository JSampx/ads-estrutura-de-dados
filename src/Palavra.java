import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Palavra implements Comparable<Palavra> {

    //Atributos
    private String palavra;
    private List<Integer> ocorrencia = new ArrayList<>();

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

    public void getOcorrencia() {
        System.out.println(ocorrencia);
    }

    public void setOcorrencia(Integer ocorrencia) {
        this.ocorrencia.add(ocorrencia);
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


    @Override
    public int compareTo(Palavra p) {
        if (this.getPalavra().compareTo(p.getPalavra()) != 0){
            return this.getPalavra().compareTo(p.getPalavra());
        }else return p.getPalavra().compareTo(this.getPalavra());
    }
}

