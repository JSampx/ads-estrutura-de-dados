import java.io.FileNotFoundException;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//        DocumentIO doc = new DocumentIO();
//        System.out.println(doc.readFile("filename.txt"));

         Palavra[] vetor = new Palavra[31];
         var palavra1 = new Palavra("Alberto");
         int a = Hash.funcHash(palavra1);
         var palavra2 = new Palavra("Alceu");
         var palavra3 = new Palavra("Amadeu");
         palavra1.setSeguinte(palavra2);
         palavra2.setSeguinte(palavra3);
         vetor[a] = palavra1;
         for (int i = 0; i < vetor.length; i++){
             System.out.println("Posição "+ i + " "+ vetor[i]);
         }


    }
    public boolean checkVector(){

        return false;
    }

}