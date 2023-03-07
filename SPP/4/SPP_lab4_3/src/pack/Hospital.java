package pack;
import java.util.ArrayList;

public class Hospital {
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
