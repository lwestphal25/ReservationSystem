public class Reservation {
    public int numPeople;
    public double time;
    public int priority;
    public long timeMade;

    public boolean indoors;

    public boolean standard;

    // if you're inside you can have maximum 4 people

    // System.currentTimeMillis()


    public Reservation(int pnumPeople, double ptime, int ppriority, long ptimeMade, boolean pindoors, boolean pstandard){
        numPeople = pnumPeople;
        time = ptime;
        priority = ppriority;
        timeMade = ptimeMade;
        indoors = pindoors;
        standard = pstandard;

    }

    public void makeString(){
       System.out.println("Reservation for this many people: "+numPeople+". Made for this time: " +time+". Made at this time: "+timeMade+". Given priority number: "+priority);
    }
}
