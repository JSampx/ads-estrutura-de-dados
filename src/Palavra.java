import java.util.List;

public class Palavra {

    //Atributos
    private String palavra;
    private List<Integer> ocorrencia;

    //Construtor com parâmetros
    public Palavra(String palavra) {
        this.palavra = palavra;
    }

    //Construtor sem parâmetros
    public Palavra() {

    }


    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        palavra = palavra;
    }

    public void getOcorrencia() {
        System.out.println(ocorrencia);
    }

    public void setOcorrencia(Integer ocorrencia) {
        this.ocorrencia.add(ocorrencia);
    }


    @Override
    public String toString() {

        return palavra;
    }
}

