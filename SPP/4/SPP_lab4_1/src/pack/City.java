package pack;

import java.util.ArrayList;

public class City {
    private class Data {
        public String avenue;
        public String street;
        public String square;

        Data(String avenue, String street, String square){
            this.avenue = avenue;
            this.street = street;
            this.square = square;
        }

        public String dataToString() {
            return "Avenue: "+this.avenue
                    + "\nStreet: "+this.street
                    + "\nSquare: "+this.square
                    + "\n-------------------------";
        }
    }
    ArrayList<Data> dataList = new ArrayList<>();

    public void addData(String avenue, String street, String square) {
        Data d = new Data(avenue, street, square);
        dataList.add(d);
    }

    public void show() {
        for(Data d : dataList) {
            System.out.println(d.dataToString());
        }
    }
}
