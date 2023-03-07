package pack;

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