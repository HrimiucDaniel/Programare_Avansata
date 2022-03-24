import java.io.IOException;

public class Lab5 {
    public static void main(String[] args) throws IOException {
        Catalog c1 = new Catalog();
        c1.setName("Catalogul_1");
        Item b1 = new Books("01","Craiasa din Povesti","LA Bucuresti");
        Item a1 = new Article("02","Articol cu fainosag","Undeva");
        Item b2 = new Books("04","Scufita Rosie si cei sapte pitici","Mhm");
        c1.add(b1);
        c1.add(b2);
        c1.add(a1);
        c1.add(a1);
        c1.add(a1);c1.add(a1);c1.add(a1);

        CatalogUtil.save(c1,"C:\\Users\\Rogue EX\\Desktop\\New folder\\txt2.txt");
    }
}
