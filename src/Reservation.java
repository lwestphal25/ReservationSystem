public class Reservation {
    public int numPeople;
    public double time;
    public int priority;
    public long timeMade;

    // System.currentTimeMillis()


    public Reservation(int pnumPeople, double ptime, int ppriority, long ptimeMade){
        numPeople = pnumPeople;
        time = ptime;
        priority = ppriority;
        timeMade = ptimeMade;

    }

    public void makeString(){
       System.out.println("Reservation for this many people: "+numPeople+". Made for this time: " +time+". Made at this time: "+timeMade+". Given priority number: "+priority);
    }
}
