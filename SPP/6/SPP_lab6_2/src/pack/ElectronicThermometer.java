package pack;
import java.util.Random;

public class ElectronicThermometer implements Thermometer {
    private int Temperature = 0;

    public int GetTemperature() {
        return Temperature;
    }
    public void SetTemperature(int temperature) {
        Temperature = temperature;
    }
    public void MeasureTheTemperature() {
        Random rand = new Random();
        SetTemperature(rand.nextInt(35, 40));
        System.out.println("Температура тела(эл. градусник): "+Temperature);
    }
}

