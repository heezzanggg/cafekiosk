package sample.coffekiosk.uint.beverage;

public class Americano implements Beverage {

//    private static final String NAME = "아메리카노";
//    private static final int PRICE = 4000;

    @Override
    public String getName() {
        return "아메리카노";
    }

    @Override
    public int getPrice() {
        return 4000;
    }
}
