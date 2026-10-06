import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    private static LinkedList<Admin> admins = new LinkedList<>();
    private static LinkedList<Staff> staffs = new LinkedList<>();
    private static LinkedList<Doctor> doctors = new LinkedList<>();
    private static LinkedList<AuditLog> auditLogs = new LinkedList<>();
    private static LinkedList<QueuePatient> queuePatients = new LinkedList<>();
    String currentUser = "";
    private static final Scanner SCANNER = new Scanner(System.in);

    // Robust input helpers
    public static int readInt() {
        while (true) {
            try {
                String line = SCANNER.nextLine();
                return Integer.parseInt(line.trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please enter a valid integer:");
            } catch (Exception e) {
                System.out.println("Input error. Please try again:");
            }
        }
    }

    public static String readLineSafe() {
        try {
            return SCANNER.nextLine();
        } catch (Exception e) {
            System.out.println("Input error. Returning empty string.");
            return "";
        }
    }

    public static void logEvent(String action, String username, String details) {
        AuditLog log = new AuditLog(action, username, details);
        auditLogs.add(log);
    }

    public boolean authenticateAdmin(String username, String password) {
        for (Admin admin : admins) {
            if (admin.authenticate(username, password)) {
                return true;
            }
        }
        return false;
    }

    public boolean authenticateStaff(String username, String password) {
        for (Staff staff : staffs) {
            if (staff.authenticate(username, password)) {
                return true;
            }
        }
        return false;
    }

    public boolean authenticateDoctor(String username, String password) {
        for (Doctor doctor : doctors) {
            if (doctor.authenticate(username, password)) {
                return true;
            }
        }
        return false;
    }
    
    public void displayAdminMenu() {
        System.out.println("Admin Menu:");
        System.out.println("1. Manage Users");
        System.out.println("2. Manage Queue");
        System.out.println("3. View Logs");
        System.out.println("4. Logout");
    }

    public void displayStaffMenu() {
        System.out.println("Staff Menu:");
        System.out.println("1. Manage Queue");
        System.out.println("2. Logout");
    }
    
    public void displayDoctorMenu() {
        System.out.println("Doctor Menu:");
        System.out.println("1. Manage Patients");
        System.out.println("2. Logout");
    }

    public void manageAdminMenu() {
        boolean isContinue = true;
        logEvent("ACCESS_MENU","", "Admin menu displayed");
        do {
            displayAdminMenu();
            // Admin management logic to be implemented
            System.out.println("Enter your choice: ");
            int choice = readInt();
            switch (choice) {
                case 1:
                    manageUsers();
                    break;
                case 2:
                    manageQueue();
                    break;
                case 3:
                    viewAuditLogs();
                    break;
                case 4:
                    isContinue = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (isContinue);
    }

    public void manageStaffMenu() {
        boolean isContinue = true;
        logEvent("ACCESS_MENU","", "Staff menu displayed");
        do {
            displayStaffMenu();
            // Staff management logic to be implemented
            System.out.println("Enter your choice: ");
            int choice = readInt();
            switch (choice) {
                case 1:
                    manageQueue();
                    break;
                case 2:
                    isContinue = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (isContinue);
    }

    public void manageDoctorMenu() {
        boolean isContinue = true;
        logEvent("ACCESS_MENU","", "Doctor menu displayed");
        do {
            displayDoctorMenu();
            // Doctor management logic to be implemented
            System.out.println("Enter your choice: ");
            int choice = readInt();
            switch (choice) {
                case 1:
                    managePatients();
                    break;
                case 2:
                    isContinue = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (isContinue);
    }

    public void manageUsers() {
        boolean isContinue = true;
        do {
            System.out.println("User Management:");
            System.out.println("1. Add User");
            System.out.println("2. Remove User");
            System.out.println("3. View Users");
            System.out.println("4. Back to Main Menu");
            System.out.println("Enter your choice: ");
            int choice = readInt();
            switch (choice) {
                case 1:
                    addUsers();
                    break;
                case 2:
                    deleteUsers();
                    break;
                case 3:
                    viewUsers();
                    break;
                case 4:
                    isContinue = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (isContinue);
    }

    public void viewUsers() {
        System.out.println("List of Users:");
        logEvent("VIEW_USERS", currentUser, "Viewed all users");
        System.out.println("Admins:");
        for (Admin admin : admins) {
            System.out.println("- " + admin.getName() + " (" + admin.getUsername() + ")");
        }
        System.out.println("Staffs:");
        for (Staff staff : staffs) {
            System.out.println("- " + staff.getName() + " (" + staff.getUsername() + ")");
        }
        System.out.println("Doctors:");
        for (Doctor doctor : doctors) {
            System.out.println("- " + doctor.getName() + " (" + doctor.getUsername() + ")");
        }
    }

    public void viewDoctors() {
        System.out.println("List of Doctors:");
        logEvent("VIEW_DOCTORS", currentUser, "Viewed list of doctors");
        for (Doctor doctor : doctors) {
            System.out.println("- " + doctor.getName() + " (" + doctor.getUsername() + ")");
        }
    }

    public void addUsers() {
        System.out.println("Add User:");
        System.out.println("Select User Type (1. Admin, 2. Staff, 3. Doctor): ");
        int userType = readInt();
        System.out.println("Enter Name: ");
        String name = readLineSafe();
        System.out.println("Enter Username: ");
        String username = readLineSafe();
        System.out.println("Enter Password: ");
        String password = readLineSafe();

        switch (userType) {
            case 1:
                admins.add(new Admin(name, username, password));
                System.out.println("Admin added successfully.");
                logEvent("ADD_USER", currentUser, "Added Admin: name=" + name + ", username=" + username);
                break;
            case 2:
                staffs.add(new Staff(name, username, password));
                System.out.println("Staff added successfully.");
                logEvent("ADD_USER", currentUser, "Added Staff: name=" + name + ", username=" + username);
                break;
            case 3:
                doctors.add(new Doctor(name, username, password));
                System.out.println("Doctor added successfully.");
                logEvent("ADD_USER", currentUser, "Added Doctor: name=" + name + ", username=" + username);
                break;
            default:
                System.out.println("Invalid user type selected.");
        }
    }

    public void deleteUsers() {
        System.out.println("List of Users:");
        viewUsers();
        System.out.println("Delete User:");
        System.out.println("Enter Username of the user to delete: ");
        String username = SCANNER.nextLine();

        boolean found = false;

        for (Admin admin : admins) {
            if (admin.getUsername().equals(username)) {
                admins.remove(admin);
                System.out.println("Admin deleted successfully.");
                logEvent("DELETE_USER", currentUser, "Deleted Admin: username=" + username);
                found = true;
                break;
            }
        }
        if (!found) {
            for (Staff staff : staffs) {
                if (staff.getUsername().equals(username)) {
                    staffs.remove(staff);
                    System.out.println("Staff deleted successfully.");
                    logEvent("DELETE_USER", currentUser, "Deleted Staff: username=" + username);
                    found = true;
                    break;
                }
            }
        }
        if (!found) {
            for (Doctor doctor : doctors) {
                if (doctor.getUsername().equals(username)) {
                    doctors.remove(doctor);
                    System.out.println("Doctor deleted successfully.");
                    logEvent("DELETE_USER", currentUser, "Deleted Doctor: username=" + username);
                    found = true;
                    break;
                }
            }
        }
        if (!found) {
            System.out.println("User not found.");
            logEvent("DELETE_USER_FAILED", currentUser, "Attempted delete of non-existent user: username=" + username);
        }
    }

    public void manageQueue() {
        // Queue management logic to be implemented
        boolean isContinue = true;
        do {
            System.out.println("Queue Management:");
            System.out.println("1. Add Patient to Queue");
            System.out.println("2. Remove Patient from Queue");
            System.out.println("3. View Queue");
            System.out.println("4. Back to Main Menu");
            System.out.println("Enter your choice: ");
            int choice = readInt();
            switch (choice) {
                case 1:
                    addPatientToQueue();
                    break;
                case 2:
                    removePatientFromQueue();
                    break;
                case 3:
                    viewQueue();
                    break;
                case 4:
                    isContinue = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (isContinue);
    }

    public void addPatientToQueue() {
        System.out.println("Enter Patient Name: ");
        String name = SCANNER.nextLine();
        System.out.println("Enter Appointment Title: ");
        String appointmentTitle = SCANNER.nextLine();
        System.out.println("Enter Status: ");
        String status = SCANNER.nextLine();
        viewDoctors();
        Doctor selectedDoctor = null;
        while (true) {
            System.out.println("Enter Doctor's Username: ");
            String doctorUsername = SCANNER.nextLine();
            for (Doctor doctor : doctors) {
                if (doctor.getUsername().equals(doctorUsername)) {
                    selectedDoctor = doctor;
                    break;
                }
            }
            if (selectedDoctor == null) {
                System.out.println("Doctor not found. Please try again.");
                continue;
            }
            break;
        }
        Appointment appointment = new Appointment(appointmentTitle, status, null, selectedDoctor);
        Patient patient = new Patient(name, appointment);
        System.out.println("Is this an emergency case? (yes/no): ");
        String emergencyInput = SCANNER.nextLine();
        boolean emergency = emergencyInput.equalsIgnoreCase("yes");
        
        QueuePatient qp = new QueuePatient(patient, emergency);
        if (emergency) {
            queuePatients.addFirst(qp);
            System.out.println("Emergency patient " + patient.getName() + " added to the front of the queue.");
            logEvent("ADD_QUEUE", currentUser, "Added emergency patient: name=" + patient.getName() + ", doctor=" + selectedDoctor.getUsername());
            return;
        }
        queuePatients.addLast(qp);
        System.out.println("Patient " + patient.getName() + " added to the queue.");
        logEvent("ADD_QUEUE", currentUser, "Added patient: name=" + patient.getName() + ", doctor=" + selectedDoctor.getUsername());
    }

    public void removePatientFromQueue() {
        System.out.println("Enter Patient Name: ");
        String name = SCANNER.nextLine();
        boolean found = false;
        for (QueuePatient qp : queuePatients) {
            if (qp.getPatient().getName().equals(name)) {
                queuePatients.remove(qp);
                System.out.println("Patient " + name + " removed from the queue.");
                logEvent("REMOVE_QUEUE", currentUser, "Removed patient from queue: name=" + name);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Patient " + name + " not found in the queue.");
            logEvent("REMOVE_QUEUE_FAILED", currentUser, "Attempted remove of non-existent patient: name=" + name);
        }
    }

    public void viewQueue() {
        System.out.println("Current Queue:");
        logEvent("VIEW_QUEUE", currentUser, "Viewed queue, size=" + queuePatients.size());
        for (QueuePatient qp : queuePatients) {
            System.out.println("- " + qp.getPatient().getName() + (qp.isEmergency() ? " (Emergency)" : ""));
        }
    }

    public void managePatients() {
        // Patient management logic to be implemented
        boolean isContinue = true;
        do {
            System.out.println("Patient Management:");
            System.out.println("1. View Patients");
            System.out.println("2. Handle Patients");
            System.out.println("3. Back to Main Menu");
            System.out.println("Enter your choice: ");
            int choice = readInt();
            switch (choice) {
                case 1:
                    viewPatients();
                    break;
                case 2:
                    handlePatients();
                    break;
                case 3:
                    isContinue = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (isContinue);
    }

    public void viewPatients() {
        for (Doctor doctor : doctors) {
            if (currentUser.equals(doctor.getUsername())) {
                System.out.println("Patients of Dr. " + doctor.getName() + ":");
                logEvent("VIEW_MY_PATIENTS", currentUser, "Doctor viewed their patients");
                for (QueuePatient qp : queuePatients) {
                    if (qp.getPatient().getAppointment().getDoctor().getUsername().equals(doctor.getUsername())) {
                        System.out.println("- " + qp.getPatient().getName() + (qp.isEmergency() ? " (Emergency)" : ""));
                    }
                }
                break;
            }
        }
    }

    public void handlePatients() {
        // Select the first patient in the queue assigned to the current doctor
        Patient patientToHandle = null;
        for (Doctor doctor : doctors) {
            if (currentUser.equals(doctor.getUsername())) {
                for (QueuePatient qp : queuePatients) {
                    if (qp.getPatient().getAppointment().getDoctor().getUsername().equals(doctor.getUsername())) {
                        System.out.println("Handling patient: " + qp.getPatient().getName());
                        patientToHandle = qp.getPatient();
                        break;
                    }
                }
                break;
            }
        }
        
        if (patientToHandle == null) {
            System.out.println("No patients in your queue.");
            return;
        }

        System.out.println("Enter new status for the appointment: ");
        String newStatus = SCANNER.nextLine();
        System.out.println("Enter diagnosis: ");
        String diagnosis = SCANNER.nextLine();
        System.out.println("Enter treatment details: ");
        String treatmentDetails = SCANNER.nextLine();
        System.out.println("Enter prescription details: ");
        String prescriptionDetails = SCANNER.nextLine();
        patientToHandle.getAppointment().setStatus(newStatus);
        MedicalRecord medicalRecord = new MedicalRecord(diagnosis, treatmentDetails, prescriptionDetails);
        patientToHandle.getAppointment().setMedicalRecord(medicalRecord);
        System.out.println("Patient " + patientToHandle.getName() + " has been handled successfully.");
        logEvent("HANDLE_PATIENT", currentUser, "Handled patient: name=" + patientToHandle.getName() + ", status=" + newStatus + ", diagnosis=" + diagnosis);
        for (QueuePatient qp : queuePatients) {
            if (qp.getPatient().getName().equals(patientToHandle.getName())) {
                queuePatients.remove(qp);
                break;
            }
        }
    }

    public void viewAuditLogs() {
        System.out.println("Audit Logs:");
        for (AuditLog log : auditLogs) {
            System.out.println(log);
        }
    }

    public static void main(String[] args) {
        admins.add(new Admin("Admin", "admin", "adminpass"));
        staffs.add(new Staff("Staff", "staff", "staffpass"));
        doctors.add(new Doctor("Dr. Smith",  "drsmith", "docpass"));
        System.out.println("======================================");
        System.out.println("Welcome to Hospital Management System");
        System.out.println("======================================");
        int loginAttempts = 0;
        boolean isContinue = true;
        while (isContinue) {
            System.out.println("Please select the menu:");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.println("Enter your choice: ");
            int menuChoice = readInt();

            switch (menuChoice) {
                case 1:
                    System.out.println("Username: ");
                    String username = SCANNER.nextLine();
                    System.out.println("Password: ");
                    String password = SCANNER.nextLine();
        
                    Main app = new Main();
        
                    if (app.authenticateAdmin(username, password)) {
                        System.out.println("Login successful as Admin.");
                        app.currentUser = username;
                        logEvent("LOGIN_SUCCESS", username, "Logged in as Admin");
                        app.manageAdminMenu();
                        break;
                    } else if (app.authenticateStaff(username, password)) {
                        System.out.println("Login successful as Staff.");
                        app.currentUser = username;
                        logEvent("LOGIN_SUCCESS", username, "Logged in as Staff");
                        app.manageStaffMenu();
                        break;
                    } else if (app.authenticateDoctor(username, password)) {
                        System.out.println("Login successful as Doctor.");
                        app.currentUser = username;
                        logEvent("LOGIN_SUCCESS", username, "Logged in as Doctor");
                        app.manageDoctorMenu();
                        break;
                    } else {
                        System.out.println("Invalid credentials. Please try again.");
                        logEvent("LOGIN_FAILED", username, "Invalid credentials");
                        loginAttempts++;
                        if (loginAttempts >= 3) {
                            System.out.println("Too many failed login attempts. Exiting.");
                            logEvent("LOGIN_LOCKOUT", username, "Too many failed login attempts");
                        }
                    }
                    break;
                case 2:
                    isContinue = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        System.out.println("============================================");
        System.out.println("Exiting Hospital Management System. Goodbye!");
        System.out.println("============================================");

        SCANNER.close();
    }
}