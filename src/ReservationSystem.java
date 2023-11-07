import java.util.Scanner;
import java.util.ArrayList;
public class ReservationSystem {
    int waitlistsMade = 0;

    Reservation[] reservations = new Reservation[10];
    ArrayList<Reservation> waitlist = new ArrayList<>();
    public static void main(String[] args) {
       ReservationSystem jarvis = new ReservationSystem();
    }


    public ReservationSystem(){
        //Reservation r = new Reservation(1, 1, 2, 2);
        //r.makeString();

        chooseMethod();



    }

    public void addReservation (int numPeople, double time, int priority, long timeMade, boolean indoors, boolean standard){
        for (int i=0;i<reservations.length;i++){
            if (reservations[i] == null){
                reservations[i] = new Reservation(numPeople, time, priority, timeMade, indoors, standard);
                break;
            }
        }

    }
    public void addWaitlist(int numPeople, double time, int priority, long timeMade, boolean indoors, boolean standard){
        waitlist.add(new Reservation(numPeople, time, priority, timeMade,  indoors,  standard));
        waitlistsMade++;
    }

    public void removeReservation(){
        for (int i=0;i<reservations.length;i++){
            if (reservations[i] == null){
                if (waitlistsMade == 0){
                    reservations[i-1] = null;
                }
                else{
                    reservations[i-1] = waitlist.get(0);
                    waitlist.remove(0);
                    waitlistsMade--;
                    break;
                }

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

    public void displayWaitList(){
        for (Reservation r : waitlist){
            if (r == null){
                System.out.println("reservation does not exist");
            }else{
                r.makeStringWaitlist();
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
        else if (c.equals("2")){
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
        else if (c.equals("3")){
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
            System.out.println("Please type your choice again");
        }

    }




    public void chooseMethod() {
        System.out.println("Welcome to our Reservation System. Follow the prompts, and type STOP at any time to exit the reservation system, and press the enter key to move to the next action when you need it. Type anything to continue");
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Type one of the following numbers: ADD RESERVATION(1), REMOVE RESERVATION(2), SEE RESERVATIONS(3), SORT RESERVATIONS(4)");
            String method = scan.nextLine();
            if (method.equals("1")) {
                if (reservations[reservations.length - 1] == null) {
                    System.out.println("Please enter the size of the reservation (number of people between 1 and 20):");
                    String numPeople = scan.nextLine();
                    boolean done = false;
                    while (!done){
                        try {
                            int test = Integer.valueOf(numPeople);
                            if (Integer.valueOf(numPeople) > 0 && Integer.valueOf(numPeople) < 20 ){
                                done = true;
                            }else{
                                System.out.println("please retype your answer");
                                numPeople = scan.nextLine();
                            }

                        }
                        catch(Exception e){
                            System.out.println("please retype your answer");
                            numPeople = scan.nextLine();
                        }
                    }

                    System.out.println("Please enter the time you would like to make you reservation for (hour time between 0 and 24):");
                    String time = scan.nextLine();

                    done = false;
                    while (!done){
                        try {
                            int test = Integer.valueOf(time);

                            if (Integer.valueOf(time) > 0 && Integer.valueOf(time) < 24 ){
                                done = true;
                            }else{
                                System.out.println("please retype your answer");
                                time = scan.nextLine();

                            }

                        }
                        catch(Exception e){
                            System.out.println("please retype your answer");
                            time = scan.nextLine();

                        }
                    }

                    System.out.println("Would you like to sit indoors? (type y for indoors and n for outdoors)");
                    boolean indoors;
                    boolean standard;
                    String hold_indoors = scan.nextLine();
                    if (hold_indoors.equals("y")) {
                        indoors = true;
                        System.out.println("Would you like to sit at a standard table or at a hightop? (type y for standard and n for hightop)");
                        String hold_standard = scan.nextLine();
                        if (hold_standard.equals("y")) {
                            standard = true;
                        } else if (hold_standard.equals("n")) {
                            standard = false;
                        } else {
                            System.out.println("Your answer was unclear. By default you reservation has been set to a standard table. Continue with this process, and if you are unhappy, you can remove your reservation from the main menu");
                            standard = true;
                        }
                    }
                    else if (hold_indoors.equals("n")) {
                        indoors = false;
                        standard = true;
                    }
                    else {
                        System.out.println("Your answer was unclear. By default you reservation has been set to indoors. Continue with this process, and if you are unhappy, you can remove your reservation from the main menu");
                        indoors = true;
                        System.out.println("Would you like to sit at a standard table or at a hightop? (type y for standard and n for hightop)");
                        String hold_standard = scan.nextLine();
                        if (hold_standard.equals("y")) {
                            standard = true;
                        } else if (hold_standard.equals("n")) {
                            standard = false;
                        } else {
                            System.out.println("Your answer was unclear. By default you reservation has been set to a standard table. Continue with this process, and if you are unhappy, you can remove your reservation from the main menu");
                            standard = true;
                        }


                    }
                    addReservation(Integer.valueOf(numPeople), Integer.valueOf(time), 0, System.currentTimeMillis(), indoors, standard);
                }
             else {
                System.out.println("The current reservation system is full. You will now be adding your reservation to a waitlist");
                    System.out.println("Please enter the size of the reservation (number of people between 1 and 20):");
                    String numPeople = scan.nextLine();
                    boolean done = false;
                    while (!done){
                        try {
                            int test = Integer.valueOf(numPeople);
                            if (Integer.valueOf(numPeople) > 0 && Integer.valueOf(numPeople) < 20 ){
                                done = true;
                            }else{
                                System.out.println("please retype your answer");
                                numPeople = scan.nextLine();

                            }

                        }
                        catch(Exception e){
                            System.out.println("please retype your answer");
                            numPeople = scan.nextLine();

                        }
                    }

                    System.out.println("Please enter the time you would like to make you reservation for (hour time between 0 and 24):");
                    String time = scan.nextLine();

                    done = false;
                    while (!done){
                        try {
                            int test = Integer.valueOf(time);
                           if (Integer.valueOf(time) > 0 && Integer.valueOf(time) < 24 ){
                                done = true;
                            }else{
                                System.out.println("please retype your answer");
                                time = scan.nextLine();

                            }

                        }
                        catch(Exception e){
                            System.out.println("please retype your answer");
                            time = scan.nextLine();

                        }
                    }
                    System.out.println("Would you like to sit indoors? (type y for indoors and n for outdoors)");
                    boolean indoors;
                    boolean standard;
                    String hold_indoors = scan.nextLine();
                    if (hold_indoors.equals("y")) {
                        indoors = true;
                        System.out.println("Would you like to sit at a standard table or at a hightop? (type y for standard and n for hightop)");
                        String hold_standard = scan.nextLine();
                        if (hold_standard.equals("y")) {
                            standard = true;
                        } else if (hold_standard.equals("n")) {
                            standard = false;
                        } else {
                            System.out.println("Your answer was unclear. By default you reservation has been set to a standard table. Continue with this process, and if you are unhappy, you can remove your reservation from the main menu");
                            standard = true;
                        }
                    }
                    else if (hold_indoors.equals("n")) {
                        indoors = false;
                        standard = true;
                    }
                    else {
                        System.out.println("Your answer was unclear. By default you reservation has been set to indoors. Continue with this process, and if you are unhappy, you can remove your reservation from the main menu");
                        indoors = true;
                        System.out.println("Would you like to sit at a standard table or at a hightop? (type y for standard and n for hightop)");
                        String hold_standard = scan.nextLine();
                        if (hold_standard.equals("y")) {
                            standard = true;
                        } else if (hold_standard.equals("n")) {
                            standard = false;
                        } else {
                            System.out.println("Your answer was unclear. By default you reservation has been set to a standard table. Continue with this process, and if you are unhappy, you can remove your reservation from the main menu");
                            standard = true;
                        }


                    }
                    addWaitlist(Integer.valueOf(numPeople), Double.valueOf(time), 0, System.currentTimeMillis(), indoors, standard);
            }
        }
            else if (method.equals("2")){
                if (reservations[0] == null){
                    System.out.println("There are currently no reservations");
                }
                else{
                    removeReservation();
                }


            }
            else if (method.equals("3")){
                System.out.println("Would you like to see the currently queued reservations(1), or the reservations on the waitlist(2)? ");
                String choice = scan.nextLine();
                if (choice.equals("1")){
                    if (reservations[0] == null){
                        System.out.println("There are currently no reservations in the system");
                    }
                    else{
                        displayReservations();
                    }
                }
                else if (choice.equals("2")){
                    if (waitlistsMade == 0){
                        System.out.println("There are currently no reservations in the waitlist");
                    }
                    else{
                        displayWaitList();
                    }
                }
                else{
                   System.out.println("please retype your answer: either see reservations (1) or see waitlist (2)");
                   choice = scan.nextLine();
                    if (choice.equals("1")){
                        if (reservations[0] == null){
                            System.out.println("There are currently no reservations in the system");
                        }
                        else{
                            displayReservations();
                        }
                    }
                    else if (choice.equals("2")){
                        if (waitlistsMade == 0){
                            System.out.println("There are currently no reservations in the waitlist");
                        }
                        else{
                            displayWaitList();
                        }
                    }
                    else{
                        System.out.println("Your answer was unclear again. As a result, both the reservations in the system and the reservations on the waitlist will be printed");
                    }
                }
            }
            else if (method.equals("4")){
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
            else{
               System.out.println("Please type your choice again");
            }


        }


        

    }







}
