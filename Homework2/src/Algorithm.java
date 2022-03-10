/**
 * the Algorithm class in which we get a problem and generate a possible solution
 * We have only the Problem atribute which specifiesc the problem for which we need to generate a solution
 * the solve methods uses a simple greedy algorithm in which for each room we test if we could add an event keeping in mind the capacity
 *and the time that the event uses
 */
public  class Algorithm {
    private Problem pb = new Problem();


    public Algorithm() {
    }

    public Algorithm(Problem pb) {
        this.pb = pb;
    }
    public Solution solve() {
        Solution sv = new Solution();
        sv.setPb(pb);
        Room[] assignement = new Room[25];
        int prevEndTime;
        for (int i = 0; i < pb.getRooomsNumber(); i++) {
            prevEndTime = 0;
            for (int j = 0; j < pb.getEventsNumber(); j++) {
                if (pb.getRoom(i).getCapacity() >= pb.getEvent(j).getSize() && assignement[j]==null) {
                    if (pb.getEvent(j).getStart() >= prevEndTime) {
                        prevEndTime = pb.getEvent(j).getEnd();
                        assignement[j] = pb.getRoom(i);
                    }
                }
            }
        }
        sv.setAssignement(assignement);
        return sv;
    }


}
