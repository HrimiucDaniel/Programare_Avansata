public class AddCommand extends Commands{
    public  static void addItem(Catalog cx, Item ix) {
        cx.getItems().add(ix);
    }
}
