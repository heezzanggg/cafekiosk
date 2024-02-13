package sample.coffekiosk.uint.beverage;

public class Latte implements Beverage {

//    private static final String NAME = "라떼";
//    private static final int PRICE = 4500;

    @Override
    public String getName() {
        return "라떼";
    }

    @Override
    public int getPrice() {
        return 4500;
    }
}
