package FIleIO;

import java.io.*;

public class Question1 {
    static void main() {
        String path = "C:\\Users\\asadm\\IdeaProjects\\Main\\notes.txt";
        File file = new File(path);

        //This is the block for writing into a file.
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(path))){

            FileWriter writer2 = new FileWriter("notes.txt",true); // true means appending to file
            System.out.println("That file Exist.");
            writer.write("Name: Muhammad Asad Muneer");
            writer.write("\nUniversity: Iqra University Main Campus");
            writer.write("\nI am Learning DSA and building projects #LearningInPublic");
            writer2.close();

        }catch (IOException e){
            System.err.println(e.getMessage());
        }


        //This is the block for reading file character by character
        try(FileReader reader = new FileReader(path)) {

            int numberOfCharacters = 0;
            int ch;
            while ((ch = reader.read()) != -1) {
                numberOfCharacters++;
                System.out.print((char) ch);
            }
            System.out.println();
            System.out.println("Total Number of Characters: "+ numberOfCharacters);

        }catch (IOException e){
            System.err.println(e.getMessage());
        }


        //This is the block for reading file Line by line
        //This is faster compare to reading character by character.
        try(BufferedReader reader = new BufferedReader(new FileReader("notes.txt"))){

            String line = reader.readLine();
            while (line != null){
                System.out.println(line);
                line = reader.readLine();
            }

        }catch (IOException e){
            System.err.println(e.getMessage());
        }


        System.out.println("Size of File: "+ file.length()+" bytes");
    }
}
