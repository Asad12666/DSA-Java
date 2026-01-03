package FIleIO;
import java.io.*;

public class ReadingFile {
    static void main() {
        String filePath = "C:\\Users\\asadm\\IdeaProjects\\Main\\output.txt";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            System.out.println("That file exist.");
            String line;
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }
            reader.close();
        }
        catch (FileNotFoundException e){
            System.err.println("Could not found the file");
        }
        catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
}
