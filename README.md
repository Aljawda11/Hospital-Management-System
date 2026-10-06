# Hospital Management System

A Java-based Hospital Management System developed to manage core hospital operations, including patients, doctors, appointments, medical records, patient queues, user roles, and system activity logs.

The project demonstrates object-oriented programming, data structures, role-based system design, and the organization of healthcare-related operations using Java.

## Features

- Patient management
- Doctor and staff management
- Appointment management
- Medical record management
- Patient queue handling
- Emergency patient prioritization
- Role-based users including:
  - Admin
  - Doctor
  - Staff
  - Patient
- User authentication
- Audit logging for system activities
- Data management using Java collections and LinkedList

## Technologies & Concepts

- Java
- Object-Oriented Programming (OOP)
- LinkedList
- Data Structures
- Role-Based Access
- Queue Management
- Console-Based Application

## Project Structure

| File | Purpose |
| --- | --- |
| `Main.java` | Application entry point and main system flow |
| `User.java` | Base user model |
| `Admin.java` | Administrator functionality |
| `Doctor.java` | Doctor-related operations |
| `Staff.java` | Staff-related operations |
| `Patient.java` | Patient information and functionality |
| `Appointment.java` | Appointment management |
| `MedicalRecord.java` | Patient medical records |
| `QueuePatient.java` | Patient queue and priority handling |
| `AuditLog.java` | Records system activities |

## System Design

The system uses object-oriented programming principles to separate hospital entities and responsibilities into individual Java classes.

Patient queue management is implemented using data structures to organize patients and prioritize urgent cases when required.

## How to Run

1. Install the Java Development Kit (JDK).
2. Download or clone this repository.
3. Open the project directory in a terminal.
4. Compile the Java files:

```bash
javac *.java
```

5. Run the application:

```bash
java Main
```

## Author

**Abdullah Ibrahim Aljawda**  
Software Engineering Student — Universiti Tun Hussein Onn Malaysia (UTHM)
