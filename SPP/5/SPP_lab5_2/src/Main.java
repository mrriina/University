import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Transport> list = new ArrayList<>();
        Car car1 = new Car(21.0);
        Bicycle bicycle1 = new Bicycle(2.4);
        Cart cart1 = new Cart(6.0);

        list.add(car1);
        list.add(bicycle1);
        list.add(cart1);

        for(Transport t : list) {
            t.getPrice();
            t.getTime();
        }
    }
}

abstract class Transport {
    private Double kilometersCount;
    public Transport(Double km) {
        this.kilometersCount = km;
    }
    public Double getKilometersCount() {
        return this.kilometersCount;
    }
    public abstract void getPrice();
    public abstract void getTime();
}

class Car extends Transport {
    private Double speed = 70.0;
    private Double priceOneKm = 0.8;
    public Car(Double km) {
        super(km);
    }
    public Double getSpeed() {
        return this.speed;
    }
    public Double getPriceOneKm() {
        return this.priceOneKm;
    }
    public void getPrice() {
        System.out.println("Price: "+(super.getKilometersCount()*this.priceOneKm));
    }
    public void getTime() {
        System.out.println("Time: "+(super.getKilometersCount()/this.speed) + "h");
    }
}

class Bicycle extends Transport {
    private Double speed = 15.0;
    private Double priceOneKm = 0.3;

    public Bicycle(Double km) {
        super(km);
    }
    public Double getSpeed() {
        return this.speed;
    }
    public Double getPriceOneKm() {
        return this.priceOneKm;
    }
    public void getPrice() {
        System.out.println("Price: "+(super.getKilometersCount()*this.priceOneKm));
    }
    public void getTime() {
        System.out.println("Time: "+(super.getKilometersCount()/this.speed) + "h");
    }
}

class Cart extends Transport {
    private Double speed = 30.0;
    private Double priceOneKm = 0.5;
    public Cart(Double km) {
        super(km);
    }
    public Double getSpeed() {
        return this.speed;
    }
    public Double getPriceOneKm() {
        return this.priceOneKm;
    }
    public void getPrice() {
        System.out.println("Price: "+(super.getKilometersCount()*this.priceOneKm));
    }
    public void getTime() {
        System.out.println("Time: "+(super.getKilometersCount()/this.speed) + "h");
    }
}