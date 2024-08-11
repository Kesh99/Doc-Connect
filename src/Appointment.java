public abstract class Appointment {
    private Doctor doctor;
    private Patient patient;
    private String date;
    private String time;

    public Appointment(Doctor doctor, Patient patient, String date, String time) {
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
        this.time = time;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "doctor=" + doctor.getName() +
                ", patient=" + patient.getName() +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
