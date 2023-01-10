package pack;

public class Nurse {
    private String name;
    private String surname;
    private Boolean appointmentsDone;

    public Nurse(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
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

