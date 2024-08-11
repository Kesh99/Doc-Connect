import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Controller controller = new Controller();

        while (true) {
            System.out.println("If you are a hospital administrator please press 1, If you are a patient please press 2, Press 3 to exit");
            int role = scanner.nextInt();
            scanner.nextLine();

            if (role == 3) break;

            switch (role) {
                case 1:
                    adminMenu(scanner, controller);
                    break;
                case 2:
                    patientMenu(scanner, controller);
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }
    }

    private static void adminMenu(Scanner scanner, Controller controller) {
        while (true) {
            System.out.println("Press 1 to add a doctor, press 2 to add a doctor availability, and press 3 to exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 3) break;

            switch (choice) {
                case 1:
                    controller.addDoctor(scanner);
                    break;
                case 2:
                    controller.addDoctorAvailability(scanner);
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }
    }

    private static void patientMenu(Scanner scanner, Controller controller) {
        while (true) {
            System.out.println("Press 1 to view doctors, press 2 to book an appointment, press 3 to view a selected doctor’s bookings, press 4 to register patient and press 5 to exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 5) break;

            switch (choice) {
                case 1:
                    controller.viewDoctors();
                    break;
                case 2:
                    controller.bookAppointment(scanner);
                    break;
                case 3:
                    controller.viewDoctorBookings(scanner);
                    break;
                case 4:
                    controller.registerPatient(scanner);
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }
    }
}
