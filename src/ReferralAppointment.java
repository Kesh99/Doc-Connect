public class ReferralAppointment extends Appointment {
    private String referralReason;

    public ReferralAppointment(Doctor doctor, Patient patient, String date, String time, String referralReason) {
        super(doctor, patient, date, time);
        this.referralReason = referralReason;
    }

    public String getReferralReason() {
        return referralReason;
    }

    @Override
    public String toString() {
        return "Referral Appointment{" +
                "referralReason='" + referralReason + '\'' +
                ", " + super.toString() +
                '}';
    }
}
