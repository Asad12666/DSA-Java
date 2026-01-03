package FIleIO;

import java.io.*;

public class WritingFile {
    static void main() {
        String[] names = {"Asad","Umaima","Subaiyal","Abdul Majid"};
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
            writer.write("I am Learning to write data to a file and retrieve from it.\n");
            writer.write("File I/O = reading data from files & writing data to files\n");
            writer.write("Files are persistent storage (data stays after program ends).");

            for (String name : names){
                writer.write("\n"+name);
            }
            writer.close();
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
}
