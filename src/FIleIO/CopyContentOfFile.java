package FIleIO;

import java.io.*;

public class CopyContentOfFile {
    static void main() {

        try (
                BufferedReader reader = new BufferedReader(new FileReader("output.txt"));
                BufferedWriter writer  = new BufferedWriter(new FileWriter("copiedContent.txt"))
        ){


            String line;
            while ((line = reader.readLine()) != null){
                writer.write(line);
                writer.newLine();
            }

        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
}
