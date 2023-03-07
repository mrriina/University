package pack;
import java.util.Random;

public class MercuryThermometerToElectronicThermometer implements Thermometer {
        MercuryThermometer mercuryThermometer;

        public MercuryThermometerToElectronicThermometer(MercuryThermometer thermometer) {
            mercuryThermometer = thermometer;
        }

        public void MeasureTheTemperature() {
            Random rand = new Random();
            mercuryThermometer.SetTemperature(rand.nextInt(35, 40));
            System.out.println("Температура тела: "+mercuryThermometer.GetTemperature());
        }
}

