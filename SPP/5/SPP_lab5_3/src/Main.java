import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Hospital hosp = new Hospital("Hospital №1");
        Doctor doc1 = new Doctor("Name1", "Surname1", "Surgeon");
        Nurse nurse1 = new Nurse("Name2", "Surname2");
        Patient patient1 = new Patient("Name3", "Surname3", doc1);

        hosp.addDoctor(doc1);
        hosp.showListDoctors();

        doc1.addAppointments("medicines", patient1, nurse1);
        System.out.println(patient1.getAppointments());
        System.out.println(patient1.getDischarge());
        System.out.println(nurse1.getAppointmentsDone());

        nurse1.setAppointmentsDone(patient1);
        System.out.println(nurse1.getAppointmentsDone());
        System.out.println(patient1.getDischarge());
    }
}

class Hospital {
    private String name;
    private ArrayList<Doctor> doctors = new ArrayList<>();

    public Hospital(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void showListDoctors() {
        System.out.println("Doctors:");
        for (Doctor doc : doctors) {
            System.out.println("Name: "+doc.getName()
                    +"\nSurname: "+doc.getSurname()
                    +"\nSpeciality: "+doc.getSpeciality()
                    +"\n--------------------");
        }
    }

    public void addDoctor(Doctor d) {
        doctors.add(d);
    }
}

class Person {
    private String name;
    private String surname;
    public Person(String n, String s) {
        this.name = n;
        this.surname = s;
    }
    public String getName() {
        return this.name;
    }
    public String getSurname() {
        return this.surname;
    }
}

class Doctor extends Person {
    private String speciality;

    public Doctor(String name, String surname, String speciality) {
        super(name, surname);
        this.speciality = speciality;
    }
    public String getSpeciality() {
        return this.speciality;
    }

    public void addAppointments(String appointments, Patient p, Nurse n) {
        p.setAppointments(appointments);
        p.setDischarge(false);
        n.setAppointments(false);
    }
}

class Nurse extends Person {
    private Boolean appointmentsDone;

    public Nurse(String name, String surname) {
        super(name, surname);
    }
    public Boolean getAppointmentsDone() {
        return this.appointmentsDone;
    }

    public void setAppointments(Boolean res) {
        this.appointmentsDone = res;
    }

    public void setAppointmentsDone(Patient p) {
        this.appointmentsDone = true;
        p.setDischarge(true);
    }
}

class Patient extends Person {
    private Doctor doc;
    private String appointments;
    private Boolean discharge;

    public Patient(String name, String surname, Doctor doc) {
        super(name, surname);
        this.doc = doc;
    }

    public Doctor getDoctor() {
        return this.doc;
    }
    public String getAppointments() {
        return this.appointments;
    }
    public void setAppointments(String appointments) {
        this.appointments = appointments;
    }
    public Boolean getDischarge() {
        return this.discharge;
    }
    public void setDischarge(Boolean d) {
        this.discharge = d;
    }
}