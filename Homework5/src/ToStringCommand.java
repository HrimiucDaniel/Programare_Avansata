public class ToStringCommand {
    public static String ToStringCatalog(Catalog cx) {
        StringBuilder sb = new StringBuilder("");
        sb.append("Catalog ");
        sb.append(cx.getName());
        sb.append(" :\n");
        for (int i = 0; i < cx.getItems().size(); i++) {
            sb.append(cx.getItems().toArray()[i]);
            sb.append("\n");
        }
        String sx = sb.toString();
        return sx;
    }
}
