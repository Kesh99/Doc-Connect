import java.util.*;

public class Doctor extends Person {
    private String specialization;
    private List<String> availability = new ArrayList<>();
    private Map<String, List<Appointment>> appointments = new HashMap<>();

    public Doctor(String id, String name, String specialization, String contact) {
        super(id, name, contact);
        this.specialization = specialization;
    }

    public void addAvailability(String date) {
        availability.add(date);
        appointments.put(date, new ArrayList<>());
    }

    public boolean isAvailable(String date) {
        return availability.contains(date);
    }

    public void addAppointment(Appointment appointment) {
        String date = appointment.getDate();
        if (appointments.containsKey(date)) {
            appointments.get(date).add(appointment);
        }
    }

    public void viewBookings() {
        for (String date : appointments.keySet()) {
            System.out.println("Appointments for date: " + date);
            for (Appointment appointment : appointments.get(date)) {
                System.out.println(appointment);
            }
        }
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", specialization='" + specialization + '\'' +
                ", contact='" + getContact() + '\'' +
                '}';
    }
}

