public class Patient extends Person {
    public Patient(String id, String name, String contact) {
        super(id, name, contact);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", contact='" + getContact() + '\'' +
                '}';
    }
}
