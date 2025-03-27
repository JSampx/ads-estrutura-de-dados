import java.io.*;
import java.util.Scanner;

public class DocumentIO {
/* Classe para manipular arquivos .txt na raiz do projeto*/

    public static String readFile(String file) {
        StringBuilder text = new StringBuilder();
        try {
            File fileToOpen = new File(file);
            Scanner openDocument = new Scanner(fileToOpen);
            while (openDocument.hasNextLine()) {
                text.append(" "+ openDocument.nextLine());
            }
            openDocument.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado");
            e.printStackTrace();
        }

        return text.toString();
    }

    public static void createFile() {
        String filename = "Results.txt";
        try {
            File fileToCreate = new File(filename);
            if (fileToCreate.createNewFile()) {
                System.out.println("Arquivo " + filename + " criado com sucesso.");
            } else {
                System.out.println("Arquivo " + filename + " já existe.");
            }
        } catch (IOException e) {
            System.out.println("Erro ao escrever o arquivo");
            e.printStackTrace();

        }
    }

    public static void writeFile(String filename, String text) {
        try {
            FileWriter fileToWrite = new FileWriter(filename);
            fileToWrite.write(text);
            fileToWrite.close();
            System.out.println("Arquivo gravado com sucesso");
        } catch (IOException e) {
            System.out.println("Escrita no Arquivo não permitida. Verifique as permissões");


        }

    }
}

