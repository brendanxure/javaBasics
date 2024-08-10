import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFileExample {
    public static void main(String[] args) {
        try {
            String fileName = "c:\\Users\\Senter\\IdeaProjects\\Files\\src\\output.txt";
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            bw.write("This is another sample text.");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //bw.close();
        }
    }
}
