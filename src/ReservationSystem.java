public class ReservationSystem {
    public static void main(String[] args) {
       ReservationSystem jarvis = new ReservationSystem();
    }


    public ReservationSystem(){
        Reservation r = new Reservation(1, 1, 2, 2);
        r.makeString();
        Reservation[] reservations = new Reservation[10];
//        for (int i=0;i<10;i++){
//            reservations[i].numPeople = i;
//            reservations[i].time = i;
//            reservations[i].timeMade = System.currentTimeMillis();
//            reservations[i].priority = i;
//            reservations[i].makeString();
//        }

    }
}
