import java.util.Arrays;

/**
 * The class which specifies the Solution of the problem
 * assignement[i] = specifies the room in which the event i will take place
 * we can also get and set the Problem for which the assignement astribute has the solution
 * we have getter and setter which will be used for the atributes of the class
 * the function computeUsedRooms() will compute the number of used rooms
 * the toString methods is for displaying the solution when we want
 */
public class Solution {
    private Room[] assignement = new Room[25];
    private Problem pb = new Problem();

    public Solution() {
    }

    public Solution(Problem pb) {
        this.pb = pb;
    }

    public Room getAssignement(int i) {
        return assignement[i];
    }

    public void setAssignement(Room[] assignement) {
        this.assignement = assignement;
    }

    public Problem getPb() {
        return pb;
    }

    public void setPb(Problem pb) {
        this.pb = pb;
    }

    public int computeUsedRooms(){
        int c = 0;
        for (int i = 1; i < assignement.length; i++) {
            if (assignement[i] != null) c++;
        }
        return c;

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pb.getEventsNumber(); i++) {
           sb.append(pb.getEvent(i).toString());
           sb.append(" -> ");
           sb.append(assignement[i].toString());
           sb.append("\n");
        }
        String out = sb.toString();
        return out;
    }
}
