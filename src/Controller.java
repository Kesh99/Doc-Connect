import java.util.*;

public class Controller {
    private List<Doctor> doctors = new ArrayList<>();
    private List<Patient> patients = new ArrayList<>();

    public void addDoctor(Scanner scanner) {
        System.out.println("Enter doctor ID:");
        String id = scanner.nextLine();
        System.out.println("Enter doctor name:");
        String name = scanner.nextLine();
        System.out.println("Enter doctor specialization:");
        String specialization = scanner.nextLine();
        System.out.println("Enter doctor contact number:");
        String contact = scanner.nextLine();

        Doctor doctor = new Doctor(id, name, specialization, contact);
        doctors.add(doctor);
        System.out.println("Doctor added successfully.");
    }

    public void addDoctorAvailability(Scanner scanner) {
        System.out.println("Enter doctor ID:");
        String doctorId = scanner.nextLine();
        Doctor doctor = getDoctorById(doctorId);

        if (doctor != null) {
            System.out.println("Enter availability date (yyyy-mm-dd):");
            String date = scanner.nextLine();
            doctor.addAvailability(date);
            System.out.println("Availability added successfully.");
        } else {
            System.out.println("Doctor not found.");
        }
    }

    public void viewDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("No doctors available.");
        } else {
            for (Doctor doctor : doctors) {
                System.out.println(doctor);
            }
        }
    }

    public void bookAppointment(Scanner scanner) {
        System.out.println("Enter patient ID:");
        String patientId = scanner.nextLine();
        Patient patient = getPatientById(patientId);

        if (patient == null) {
            System.out.println("Patient not found. Please register the patient first.");
            return;
        }

        System.out.println("Enter doctor ID:");
        String doctorId = scanner.nextLine();
        Doctor doctor = getDoctorById(doctorId);

        if (doctor == null) {
            System.out.println("Doctor not found.");
            return;
        }

        System.out.println("Enter appointment type (1 for General, 2 for Referral):");
        int appointmentType = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.println("Enter appointment date (yyyy-mm-dd):");
        String date = scanner.nextLine();
        if (!doctor.isAvailable(date)) {
            System.out.println("Doctor is not available on this date.");
            return;
        }

        System.out.println("Enter appointment time (HH:mm):");
        String time = scanner.nextLine();

        Appointment appointment;
        if (appointmentType == 1) {
            appointment = new GeneralAppointment(doctor, patient, date, time);
        } else if (appointmentType == 2) {
            System.out.println("Enter referral reason:");
            String referralReason = scanner.nextLine();
            appointment = new ReferralAppointment(doctor, patient, date, time, referralReason);
        } else {
            System.out.println("Invalid appointment type.");
            return;
        }

        doctor.addAppointment(appointment);
        System.out.println("Appointment booked successfully.");
    }

    public void viewDoctorBookings(Scanner scanner) {
        System.out.println("Enter doctor ID:");
        String doctorId = scanner.nextLine();
        Doctor doctor = getDoctorById(doctorId);

        if (doctor != null) {
            doctor.viewBookings();
        } else {
            System.out.println("Doctor not found.");
        }
    }

    public void registerPatient(Scanner scanner) {
        System.out.println("Enter patient ID:");
        String id = scanner.nextLine();
        System.out.println("Enter patient name:");
        String name = scanner.nextLine();
        System.out.println("Enter patient contact number:");
        String contact = scanner.nextLine();

        Patient patient = new Patient(id, name, contact);
        patients.add(patient);
        System.out.println("Patient registered successfully.");
    }

    private Doctor getDoctorById(String id) {
        for (Doctor doctor : doctors) {
            if (doctor.getId().equals(id)) {
                return doctor;
            }
        }
        return null;
    }

    private Patient getPatientById(String id) {
        for (Patient patient : patients) {
            if (patient.getId().equals(id)) {
                return patient;
            }
        }
        return null;
    }
}
