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
       System.out.println("A reservation for "+numPeople+" people at " +time+ " o'clock was made at "+timeMade+" milliseconds. The reservation has been given priority "+priority+ " out of 10");
    }
    public void makeStringWaitlist(){
        System.out.println("A reservation for "+numPeople+" people at " +time+ " o'clock was made at "+timeMade+" milliseconds. The reservation is on the waitlist");

    }

    public void show_tables(){
        if (indoors && standard){
            System.out.println("Reservation is inside on a standard table");
        }
        if (indoors && !standard){
            System.out.println("Reservation is inside on a hightop table");
        }
        if (!indoors){
            System.out.println("Reservation is outside on a standard table");
        }

    }
}
