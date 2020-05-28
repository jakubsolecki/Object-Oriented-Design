package pl.edu.agh.internetshop;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.edu.agh.internetshop.filters.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class OrderHistoryTest {
    private static final String customerName1 = "Jan";
    private static final String customerName2 = "Paweł";
    private static final BigDecimal productPrice1 = BigDecimal.valueOf(21);
    private static final BigDecimal productPrice2 = BigDecimal.valueOf(37);
    private static final String productName1 = "Kremówka";
    private static final String productName2 = "Szarlotka";
    private static final BigDecimal discount = BigDecimal.ONE;

    @BeforeAll
    static void addMockOrders() {
        Product prod1 = new Product(productName1, productPrice1, discount);
        Product prod2 = new Product(productName2, productPrice2, discount);
        List<Product> prodList1 = new ArrayList<>(Arrays.asList(prod2, prod1, prod2));
        List<Product> prodList2 = new ArrayList<>(Arrays.asList(prod2, prod2));

        Order order1 = new Order(prodList1, discount);
        Order order2 = new Order(prodList2, discount);

        Address address1 = mock(Address.class);
        given(address1.getName()).willReturn(customerName1);

        Address address2 = mock(Address.class);
        given(address2.getName()).willReturn(customerName2);

        Shipment shipment1 = mock(Shipment.class);
        given(shipment1.getRecipientAddress()).willReturn(address1);

        Shipment shipment2 = mock(Shipment.class);
        given(shipment2.getRecipientAddress()).willReturn(address2);

        order1.setShipment(shipment1);
        order2.setShipment(shipment2);

        OrderHistory orderHistory = OrderHistory.getInstance();
        orderHistory.addOrder(order1);
        orderHistory.addOrder(order2);
    }


    @Test
    public void testPriceSearch() throws Exception {
        // given
        OrderHistory orderHistory = OrderHistory.getInstance();
        BigDecimal price = BigDecimal.valueOf(37).add(BigDecimal.valueOf(37));
        SearchStrategy searchStrategy = new PriceSearchStrategy(price);

        // when
        List<Order> orders = orderHistory.searchOrderByStrategy(searchStrategy);
        List<Order> referenceOrders = orderHistory
                .getOrders()
                .stream()
                .filter(order -> order.getPrice().equals(price))
                .collect(Collectors.toList());

        // then
        assertEquals(orders.get(0), referenceOrders.get(0));
        assertEquals(orders.size(), referenceOrders.size());


    }

    @Test
    public void testProductNameSearch() throws Exception {
        // given
        OrderHistory orderHistory = OrderHistory.getInstance();
        SearchStrategy searchStrategy = new ProductNameSearchStrategy(productName1);

        // when
        List<Order> orders = orderHistory.searchOrderByStrategy(searchStrategy);
        List<Order> referenceOrders = orderHistory
                .getOrders()
                .stream()
                .filter(order -> order.getProducts().stream()
                        .anyMatch(product -> product.getName().equals(productName1)))
                .collect(Collectors.toList());

        // then
        assertEquals(orders.get(0), referenceOrders.get(0));
        assertEquals(orders.size(), referenceOrders.size());

    }

    @Test
    public void testClientNameSearch() throws Exception {
        // given
        OrderHistory orderHistory = OrderHistory.getInstance();
        SearchStrategy searchStrategy = new ClientNameSearchStrategy(customerName1);


        // when
        List<Order> actualOrders = orderHistory.searchOrderByStrategy(searchStrategy);
        List<Order> expectedOrders = orderHistory
                .getOrders()
                .stream()
                .filter(order -> order.getShipment().getRecipientAddress()
                        .getName().equals(customerName1))
                .collect(Collectors.toList());


        // then
        assertEquals(actualOrders.size(), expectedOrders.size());
        assertEquals(actualOrders.get(0), expectedOrders.get(0));
    }

    @Test
    public void testCompositeSearch() {
        // given
        OrderHistory orderHistory = OrderHistory.getInstance();
        SearchStrategy productSearchStrategy = new ProductNameSearchStrategy(productName2);
        SearchStrategy clientSearchStrategy = new ClientNameSearchStrategy(customerName1);
        CompositeSearchStrategy searchStrategy = new CompositeSearchStrategy();
        searchStrategy.addStrategy(productSearchStrategy);
        searchStrategy.addStrategy(clientSearchStrategy);


        // when
        List<Order> actualOrders = orderHistory.searchOrderByStrategy(searchStrategy);
        List<Order> expectedOrders = orderHistory
                .getOrders()
                .stream()
                .filter(order -> order.getShipment().getRecipientAddress().getName()
                        .equals(customerName1))
                .filter(order ->
                        order.getProducts()
                                .stream()
                                .anyMatch(product -> product.getName().equals(productName2))
                )
                .collect(Collectors.toList());


        // then
        assertEquals(actualOrders.size(), expectedOrders.size());
        assertEquals(actualOrders.get(0), expectedOrders.get(0));
    }
}