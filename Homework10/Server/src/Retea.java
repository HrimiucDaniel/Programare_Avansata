import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Retea {

    private List<String> users = new ArrayList<>();
    private  Map<String, List<String>> friends = new HashMap<>();
    private  String logged = "";
    private  Map<String, List<String>> messages = new HashMap<>();
    public Retea() {
    }

    public  String getLogged() {
        return logged;
    }

    public  void setLogged(String logged) {
        this.logged = logged;
    }

    public  Map<String, List<String>> getFriends() {
        return friends;
    }

    public void send_messages(String name, String message){
        List<String> lista = new ArrayList<>();
        List<String> fr = friends.get(name);
        for(String s:fr) {
          //  if (messages.get(s)!=null) lista = messages.get(s);
            System.out.println(name+":"+message+s);
            lista.add(name+":"+message);
            messages.put(s,lista);
        }

    }

    public  Map<String, List<String>> getMessages() {
        return messages;
    }

    public  String receive_messages(String name) {
        StringBuilder sb = new StringBuilder("");
        List<String> ss = messages.get(name);
        for(String s:ss){
           sb.append(s);
           sb.append("\n");

        }
        String s = sb.toString();
    return s;
    }

    public  void add_friends(String name, String list){
        String[] array = list.split(",");
        List<String> temp = new ArrayList<>();
        for(String friend:array){
            temp.add(friend);
        }
        friends.put(name,temp);
    }

    public  void  add_user(String user){
        users.add(user);
    }

    public  List<String> getUsers() {
        return users;
    }

    public  boolean User_exists(String user) {
        return users.contains(user);
    }

    @Override
    public String toString() {
        return "Retea{" +
                "users=" + users +
                '}';
    }
}
