public class Patient {
    private String name;
    private Appointment appointment;

    public Patient(String name, Appointment appointment) {
        this.name = name;
        this.appointment = appointment;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }
}
