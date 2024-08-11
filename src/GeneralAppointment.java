public class GeneralAppointment extends Appointment {
    public GeneralAppointment(Doctor doctor, Patient patient, String date, String time) {
        super(doctor, patient, date, time);
    }

    @Override
    public String toString() {
        return "General " + super.toString();
    }
}
