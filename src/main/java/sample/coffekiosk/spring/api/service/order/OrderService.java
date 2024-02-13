package sample.coffekiosk.spring.api.service.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sample.coffekiosk.spring.api.service.order.request.OrderCreateRequest;
import sample.coffekiosk.spring.api.service.order.response.OrderResponse;
import sample.coffekiosk.spring.domain.order.Order;
import sample.coffekiosk.spring.domain.order.OrderRepository;
import sample.coffekiosk.spring.domain.product.Product;
import sample.coffekiosk.spring.domain.product.ProductRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public OrderResponse createOrder(OrderCreateRequest request, LocalDateTime registeredDateTime) {
    //상품 번호를 받아서(request) 해당 상품을 만들고, 그걸 order 목록으로 만들어준다.
        List<String> productNumbers = request.getProductNumbers();
        List<Product> products = findProductsBy(productNumbers);

        Order order = Order.create(products, registeredDateTime);
        Order SavedOrder = orderRepository.save(order);
        return OrderResponse.of(SavedOrder);
    }

    private List<Product> findProductsBy(List<String> productNumbers) {
        List<Product> products = productRepository.findAllByProductNumberIn(productNumbers);
        Map<String, Product> productMap = products.stream()
                .collect(Collectors.toMap(Product::getProductNumber, p -> p));

        List<Product> duplicateProducts = productNumbers.stream()
                .map(productMap::get)
                .toList();

        return duplicateProducts;
    }
}
