package FIleIO;

import java.io.File;

public class DeletingFile {
    static void main() {
        File file = new File("notes.txt");
        File file1 = new File("output.txt");
        File file2 = new File("copiedContent.txt");

        if (file1.delete()){
            System.out.println("File deleted successfully.");
        }else{
            System.out.println("Unable to delete file.");
        }
    }
}
