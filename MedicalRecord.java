public class MedicalRecord {
    private String diagnosis;
    private String treatmentDetails;
    private String prescriptionDetails;

    public MedicalRecord(String diagnosis, String treatmentDetails, String prescriptionDetails) {
        this.diagnosis = diagnosis;
        this.treatmentDetails = treatmentDetails;
        this.prescriptionDetails = prescriptionDetails;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getTreatmentDetails() {
        return treatmentDetails;
    }

    public void setTreatmentDetails(String treatmentDetails) {
        this.treatmentDetails = treatmentDetails;
    }

    public String getPrescriptionDetails() {
        return prescriptionDetails;
    }

    public void setPrescriptionDetails(String prescriptionDetails) {
        this.prescriptionDetails = prescriptionDetails;
    }
}