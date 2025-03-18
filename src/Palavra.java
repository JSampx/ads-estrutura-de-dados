public class Palavra {
    private String palavra;
    private int ocorrencia;

    Palavra seguinte;

    public Palavra(String palavra) {
        this.palavra = palavra;
    }

    public Palavra(){

    }


    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public int getOcorrencia() {
        return ocorrencia;
    }

    public void setOcorrencia(int ocorrencia) {
        this.ocorrencia = ocorrencia;
    }

    public void setSeguinte(String palavra){
        seguinte = new Palavra(palavra);
    }

    public Palavra getSeguinte(){
        return this.seguinte;
    }

    @Override
    public String toString() {
        return palavra;
    }
}
