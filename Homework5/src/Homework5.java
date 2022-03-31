
import java.io.IOException;

public class Homework5 {
    public static void main(String[] args) throws IOException {
        Catalog c1 = new Catalog();
        c1.setName("Catalogul_1");
        Item b1 = new Books("01","Craiasa din Povesti","C:\\Users\\Rogue EX\\Desktop\\New folder\\catalog.json");
        Item a1 = new Article("02","Articol cu fainosag","C:\\Users\\Rogue EX\\Desktop\\New folder\\catalog.json");
        Item b2 = new Books("04","Scufita Rosie si cei sapte pitici","C:\\Users\\Rogue EX\\Desktop\\New folder\\catalog.json");
        AddCommand.addItem(c1,b1);
        AddCommand.addItem(c1,a1);
        AddCommand.addItem(c1,b2);
        AddCommand.addItem(c1,a1);
        AddCommand.addItem(c1,b1);

        SaveCommand.save(c1,"C:\\Users\\Rogue EX\\Desktop\\New folder\\catalog.json");
        Catalog c2 = new Catalog();
       c2 = LoadCommand.load("C:\\Users\\Rogue EX\\Desktop\\New folder\\catalog.json");
        ListCommand.print(c2);
        ViewCommand.view(b1);

    }
}
