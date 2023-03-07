package pack;

public class MercuryThermometer implements AnalogThermometer {
    private int HeightOfTheMercuryColumn = 0;
    private int UpperBound = 100, BottomLine = 0;

    public int GetTemperature() {
        return HeightOfTheMercuryColumn;
    }
    public void SetTemperature(int heightOfTheMercuryColumn) {
        HeightOfTheMercuryColumn = heightOfTheMercuryColumn;
    }

    public int GetUpperBound() {
        return UpperBound;
    }
    public void SetUpperBound(int upperBound) {
        UpperBound = upperBound;
    }

    public int GetBottomLine() {
        return HeightOfTheMercuryColumn;
    }
    public void SetBottomLine(int bottomLine) {
        BottomLine = bottomLine;
    }

    public void RoughlyMeasureTheTemperature() {
        System.out.println("Высота ртутного столба: "+HeightOfTheMercuryColumn
                            +". Нижняя граница градусника: "+BottomLine
                            +", верхняя граница градусника "+UpperBound);
    }
}

