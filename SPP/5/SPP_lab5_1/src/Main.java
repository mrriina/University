public class Main {
    public static void main(String[] args) {
        Videoplayer vp = new Videoplayer("Videoplayer", 245.5, "GH432-65");
        vp.showType();
        vp.showAll();
    }
}
interface Technic {
    void showType();
    void showAll();
}

abstract class Player implements Technic {
    private String type;
    private Double price;
    public Player(String type, Double price) {
        this.type = type;
        this.price = price;
    }
    public String getType() {
        return this.type;
    }
    public Double getPrice() {
        return this.price;
    }
}

class Videoplayer extends Player {
    private String model;
    public Videoplayer(String type, Double price, String model) {
        super(type, price);
        this.model = model;
    }
    @Override
    public void showType() {
        System.out.println("Technic type: "+super.getType());
    }
    @Override
    public void showAll() {
        System.out.println("Technic:");
        System.out.println("Type: "+super.getType()
                          +"\nPrice: "+super.getPrice()
                          +"\nModel: "+this.model);
    }
}