import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ViewCommand {
    public static void view(Item item) throws IOException {
        Desktop desktop = Desktop.getDesktop();
       try {
           desktop.open(new File(item.location));
       }catch (IOException e){
           System.out.println("desktop open error");
       }
    }
}
