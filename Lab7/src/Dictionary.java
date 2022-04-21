import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Dictionary {
    public boolean isWord(String str){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "C:\\Users\\Rogue EX\\Desktop\\create4\\create.txt"));
            String line = reader.readLine();
            while (line != null) {
                //System.out.println(line);

                if (line.equals(str)) {System.out.println(line);return true;}
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
