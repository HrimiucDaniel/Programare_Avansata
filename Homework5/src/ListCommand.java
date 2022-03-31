public class ListCommand {
    public static void print(Catalog cx) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < cx.getItems().size(); i++) {
            sb.append(cx.getItems().toArray()[i]);
            sb.append("\n");
        }
        String sx = sb.toString();
        System.out.println(sx);
    }
}
