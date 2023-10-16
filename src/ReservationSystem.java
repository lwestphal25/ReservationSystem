public class ReservationSystem {
    int reservationsMade = 0;

    Reservation[] reservations = new Reservation[10];
    public static void main(String[] args) {
       ReservationSystem jarvis = new ReservationSystem();
    }


    public ReservationSystem(){
        //Reservation r = new Reservation(1, 1, 2, 2);
        //r.makeString();
        for (int i=0;i<reservations.length-1;i++){
            addReservation2(((int)(i*Math.random())+2), i*Math.random(), (int)(i*Math.random()), (long)(i*Math.random()));
        }
        displayReservations();
        sortReservations();
        System.out.println("-----------------------------");
        displayReservations();

    }

    public void addReservation (int numPeople, double time, int priority, long timeMade){
        reservations[reservationsMade] = new Reservation(numPeople, time, priority, timeMade);
        reservationsMade++;
    }

    public void addReservation2 (int numPeople, double time, int priority, long timeMade){
        for (int i=0;i<reservations.length;i++){
            if (reservations[i] == null){
                reservations[i] = new Reservation(numPeople, time, priority, timeMade);
                break;
            }
        }

    }

    public void displayReservations(){
        for (Reservation r : reservations){
            if (r == null){
                System.out.println("reservation does not exist");
            }else{
                r.makeString();
            }
        }
    }

    public void sortReservations(){
        Reservation filler = new Reservation(0,0,0,0);
        for (int a=0;a<reservations.length-1;a++) {
            for (int b=0; b < reservations.length-1; b++) {
                if (reservations[b] != null && reservations[b+1] != null){
                    if (reservations[b].timeMade > reservations[b + 1].timeMade) {
                        filler = reservations[b + 1];
                        reservations[b + 1] = reservations[b];
                        reservations[b] = filler;
                    }
                }
            }
        }
        for (int i=0;i<reservations.length;i++){
            if (reservations[i] != null){
                reservations[i].priority = i;
            }

        }
    }
}
