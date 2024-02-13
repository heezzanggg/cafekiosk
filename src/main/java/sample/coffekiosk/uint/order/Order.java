package sample.coffekiosk.uint.order;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import sample.coffekiosk.uint.beverage.Beverage;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class Order {
    //주문일시, 음료 리스트
    private final LocalDateTime orderDateTime;
    private final List<Beverage> beverages;
}
