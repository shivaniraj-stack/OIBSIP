import java.util.*;

class Reservation {
    int pnr;
    String passengerName;
    String trainNo;
    String trainName;
    String classType;
    String journeyDate;
    String source;
    String destination;

    Reservation(int pnr, String passengerName, String trainNo,
                String trainName, String classType,
                String journeyDate, String source,
                String destination) {

        this.pnr = pnr;
        this.passengerName = passengerName;
        this.trainNo = trainNo;
        this.trainName = trainName;
        this.classType = classType;
        this.journeyDate = journeyDate;
        this.source = source;
        this.destination = destination;
    }
}

public class OnlineReservationSystem {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Reservation> reservations = new ArrayList<>();

    static boolean login() {

        String username = "admin";
        String password = "admin123";

        System.out.println("===== LOGIN =====");

        System.out.print("Username: ");
        String user = sc.nextLine();

        System.out.print("Password: ");
        String pass = sc.nextLine();

        if (user.equals(username) && pass.equals(password)) {
            System.out.println("\nLogin Successful!");
            return true;
        }

        System.out.println("\nInvalid Credentials!");
        return false;
    }

    static void reserveTicket() {

        System.out.println("\n===== RESERVATION FORM =====");

        System.out.print("Passenger Name: ");
        String name = sc.nextLine();

        System.out.print("Train Number: ");
        String trainNo = sc.nextLine();

        String trainName;

        switch (trainNo) {
            case "101":
                trainName = "Rajdhani Express";
                break;

            case "102":
                trainName = "Shatabdi Express";
                break;

            case "103":
                trainName = "Duronto Express";
                break;

            default:
                trainName = "Unknown Train";
        }

        System.out.println("Train Name: " + trainName);

        System.out.print("Class Type: ");
        String classType = sc.nextLine();

        System.out.print("Date of Journey: ");
        String date = sc.nextLine();

        System.out.print("Source: ");
        String source = sc.nextLine();

        System.out.print("Destination: ");
        String destination = sc.nextLine();

        int pnr = 1000 + new Random().nextInt(9000);

        Reservation reservation = new Reservation(
                pnr,
                name,
                trainNo,
                trainName,
                classType,
                date,
                source,
                destination
        );

        reservations.add(reservation);

        System.out.println("\n===== RESERVATION SUCCESSFUL =====");
        System.out.println("PNR Number : " + pnr);
        System.out.println("Passenger  : " + name);
        System.out.println("Train      : " + trainName);
    }

    static void cancelTicket() {

        System.out.println("\n===== CANCELLATION FORM =====");

        System.out.print("Enter PNR Number: ");
        int pnr = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < reservations.size(); i++) {

            Reservation r = reservations.get(i);

            if (r.pnr == pnr) {

                System.out.println("\nTicket Found");
                System.out.println("Passenger : " + r.passengerName);
                System.out.println("Train     : " + r.trainName);
                System.out.println("Source    : " + r.source);
                System.out.println("Destination: " + r.destination);

                System.out.print("\nConfirm Cancellation (Y/N): ");
                char choice = sc.nextLine().toUpperCase().charAt(0);

                if (choice == 'Y') {
                    reservations.remove(i);
                    System.out.println("Ticket Cancelled Successfully!");
                } else {
                    System.out.println("Cancellation Aborted.");
                }

                return;
            }
        }

        System.out.println("PNR Not Found!");
    }
    static void viewReservations() {

    System.out.println("\n===== ALL RESERVATIONS =====");

    if (reservations.isEmpty()) {
        System.out.println("No Reservations Found!");
        return;
    }

    for (Reservation r : reservations) {

        System.out.println("----------------------------");
        System.out.println("PNR         : " + r.pnr);
        System.out.println("Passenger   : " + r.passengerName);
        System.out.println("Train No    : " + r.trainNo);
        System.out.println("Train Name  : " + r.trainName);
        System.out.println("Class Type  : " + r.classType);
        System.out.println("Journey Date: " + r.journeyDate);
        System.out.println("Source      : " + r.source);
        System.out.println("Destination : " + r.destination);
    }
}

    public static void main(String[] args) {

        if (!login()) {
            return;
        }

        while (true) {

            System.out.println("\n===== ONLINE RESERVATION SYSTEM =====");
            System.out.println("1. Reserve Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. View Reservations");
            System.out.println("4. Exit");

            System.out.print("Enter Choice: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    reserveTicket();
                    break;

                case 2:
                    cancelTicket();
                    break;

                case 3:
                    viewReservations();
                    break;

                case 4:
                    System.out.println("Thank You!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}

