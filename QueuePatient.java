import java.time.Instant;

public class QueuePatient {
    private Patient patient;
    private Instant timeAdded;
    private boolean emergency;

    public QueuePatient(Patient patient, boolean emergency) {
        this.patient = patient;
        this.emergency = emergency;
        this.timeAdded = Instant.now();
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Instant getTimeAdded() {
        return timeAdded;
    }

    public boolean isEmergency() {
        return emergency;
    }

    public void setEmergency(boolean emergency) {
        this.emergency = emergency;
    }
}