public class Homework2 {
    public static void main(String[] args) {
        Event E1 = new Event(8, 10, 100, "C1");
        Event E2 = new Event(10, 12, 100, "C2");
        Event E3 = new Event(8, 10, 30, "L1");
        Event E4 = new Event(8, 10, 30, "L2");
        Event E5 = new Event(10, 12, 30, "L3");
        Room R1 = new ComputerLab("401", 30, "windows");
        Room R2 = new ComputerLab("403", 30, "linux");
        Room R3 = new ComputerLab("405", 30, "mac");
        Room R4 = new LectureHall("309", 100, false);

        Problem pb = new Problem();
        pb.addEvent(E1);
        pb.addEvent(E2);
        pb.addEvent(E3);
        pb.addEvent(E4);
        pb.addEvent(E5);

        pb.addRoom(R1);
        pb.addRoom(R2);
        pb.addRoom(R3);
        pb.addRoom(R4);

        Algorithm greedy = new Algorithm(pb);
        Solution sol =  greedy.solve();
       System.out.println(sol);
    }

}
