public class Appointment {
    private String appointmentTitle;
    private String status;
    private MedicalRecord medicalRecord;
    private Doctor doctor;

    public Appointment(String appointmentTitle, String status, MedicalRecord medicalRecord, Doctor doctor) {
        this.appointmentTitle = appointmentTitle;
        this.status = status;
        this.medicalRecord = medicalRecord;
        this.doctor = doctor;
    }

    public String getAppointmentTitle() {
        return appointmentTitle;
    }

    public void setAppointmentTitle(String appointmentTitle) {
        this.appointmentTitle = appointmentTitle;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(MedicalRecord medicalRecord) {
        this.medicalRecord = medicalRecord;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
