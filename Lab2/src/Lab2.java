public class Lab2 {
    public static void main(String[] args){
        Room R1 = new Room(room_type.COMPUTER_LABS,"401",30);
        Room R2 = new Room(room_type.COMPUTER_LABS,"403",30);
        Room R3 = new Room(room_type.COMPUTER_LABS,"405",30);
        Room R4 = new Room(room_type.LECTURE_HALLS,"100",100);
        Event E1 = new Event(8,10,100,"C1");
        Event E2 = new Event(10,12,100,"C2");
        Event E3 = new Event(8,10,30,"L1");
        Event E4 = new Event(8,10,30,"L2");
        Event E5 = new Event(10,12,30,"L3");

        System.out.println(R1.toString() + " ," + R2.toString() + " ," + R3.toString() + " ," + R4.toString());
        System.out.println(E1.toString() + " ," + E2.toString() + " ," + E3.toString() + " ," + E4.toString() + " ," + E5.toString());

    }
}
