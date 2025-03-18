import java.io.FileNotFoundException;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//        DocumentIO doc = new DocumentIO();
//        System.out.println(doc.readFile("filename.txt"));
        String a = "Avião";
        char b = 'B';
        char c = 'C';
        int ch = (int) a.charAt(0);
        int d = (int) 'D';
        System.out.println(ch);

        Palavra palavra1 = new Palavra("Casa");
        palavra1.setSeguinte("Cedro");

        System.out.println(palavra1.getSeguinte());

    }
}