package pack;

public class Patient {
    private String name;
    private String surname;
    private Doctor doc;
    private String appointments;
    private Boolean discharge;

    public Patient(String name, String surname, Doctor doc) {
        this.name = name;
        this.surname = surname;
        this.doc = doc;
    }

    public String getName() {
        return this.name+this.surname;
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
