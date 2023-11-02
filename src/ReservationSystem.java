import java.util.Scanner;
public class ReservationSystem {
    int reservationsMade = 0;

    Reservation[] reservations = new Reservation[10];
    public static void main(String[] args) {
       ReservationSystem jarvis = new ReservationSystem();
    }


    public ReservationSystem(){
        //Reservation r = new Reservation(1, 1, 2, 2);
        //r.makeString();

        chooseMethod();



    }

    public void addReservationextra (int numPeople, double time, int priority, long timeMade, boolean indoors, boolean standard){
        reservations[reservationsMade] = new Reservation(numPeople, time, priority, timeMade, indoors, standard);
        reservationsMade++;
    }

    public void addReservation (int numPeople, double time, int priority, long timeMade, boolean indoors, boolean standard){
        for (int i=0;i<reservations.length;i++){
            if (reservations[i] == null){
                reservations[i] = new Reservation(numPeople, time, priority, timeMade, indoors, standard);
                break;
            }
        }

    }

    public void removeReservation(){
        for (int i=0;i<reservations.length;i++){
            if (reservations[i] == null){
                reservations[i-1] = null;
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

    public void sortReservations(String c){
        Reservation filler = new Reservation(0,0,0,0, false, false);

        if (c.equals("1")){
            for (int a=0;a<reservations.length-1;a++) {
                for (int b=0; b < reservations.length-1; b++) {
                    if (reservations[b] != null && reservations[b+1] != null){
                        if (reservations[b].numPeople > reservations[b + 1].numPeople) {
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
        if (c.equals("2")){
            for (int a=0;a<reservations.length-1;a++) {
                for (int b=0; b < reservations.length-1; b++) {
                    if (reservations[b] != null && reservations[b+1] != null){
                        if (reservations[b].time > reservations[b + 1].time) {
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
        if (c.equals("3")){
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
        else{
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

    public void selectionSort(){
        int[] waffles = new int[10];
        for (int i=0;i<waffles.length;i++){
            waffles[i] = (int)(100*Math.random());
            System.out.print(waffles[i] + ", ");
        }
        System.out.println();

        int n = waffles.length;

        for (int k=0;k<n-1;k++){
            int min_index= k;
            for (int v = k+1; v< n;v++){
                if (waffles[v] < waffles[min_index]){
                    min_index = v;
                }
            }
            //swap values
            int fill = waffles[min_index];
            waffles[min_index] = waffles[k];
            waffles[k] = fill;
        }

        for (int i=0;i<waffles.length;i++){
            System.out.print(waffles[i] + ", ");
        }
        System.out.println();

    }


    public void chooseMethod(){
        System.out.println("Welcome to our Reservation System. What would you like to do?");
        while (true){
            Scanner scan = new Scanner(System.in);

            System.out.println("Type one of the following numbers: ADD RESERVATION(1), REMOVE RESERVATION(2), SEE RESERVATIONS(3), SORT RESERVATIONS(4)");
            String method = scan.nextLine();
            if (method.equals("1")){
                System.out.println("Please enter the size of the reservation:");
                String numPeople = scan.nextLine();
                System.out.println("Please enter the time of Rerservation:");
                String time = scan.nextLine();
                System.out.println("Would you like to sit indoors? (type YES for indoors and NO for outdoors");
                String hold_indoors = scan.nextLine();
                boolean indoors;
                if (hold_indoors == "YES"){
                    indoors = true;
                }
                if (hold_indoors == "NO"){
                    indoors = false;
                }
                else{
                    indoors = false;
                }
                System.out.println("Would you like to sit on a hightop? (type YES for standard and NO for hightop");
                String hold_standard = scan.nextLine();
                boolean standard;
                if (hold_standard == "YES"){
                    standard = true;
                }
                if (hold_standard == "NO"){
                    standard = false;
                }
                else{
                    standard = false;
                }
                addReservation(Integer.valueOf(numPeople), Integer.valueOf(time), 0, System.currentTimeMillis(), indoors, standard);
            }
            if (method.equals("2")){
                if (reservations[0] == null){
                    System.out.println("There are currently no reservations");
                }
                else{
                    removeReservation();
                }


            }
            if (method.equals("3")){
                if (reservations[0] == null){
                    System.out.println("There are currently no reservations");
                }
                else{
                    displayReservations();
                }
            }
            if (method.equals("4")){
                if (reservations[0] == null){
                    System.out.println("There are currently no reservations");
                }
                else{
                    System.out.println("What would you like to sort your reservations by?");
                    System.out.println("Type one of the following numbers: sort by number of people(1), sort by time of reservation(2), sort by time reservation was made(3)");
                    String sort_type = scan.nextLine();
                    sortReservations(sort_type);
                }

            }

        }


        

    }







}
