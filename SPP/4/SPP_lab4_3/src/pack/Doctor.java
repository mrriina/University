package pack;

public class Doctor {
    private String name;
    private String surname;
    private String speciality;

    public Doctor(String name, String surname, String speciality) {
        this.name = name;
        this.surname = surname;
        this.speciality = speciality;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
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
