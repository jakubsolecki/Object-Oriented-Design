package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;
import pl.edu.agh.internetshop.filters.ClientNameSearchStrategy;
import pl.edu.agh.internetshop.filters.CompositeSearchStrategy;
import pl.edu.agh.internetshop.filters.PriceSearchStrategy;
import pl.edu.agh.internetshop.filters.ProductNameSearchStrategy;

import java.math.BigDecimal;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class SearchStrategyTest {

    @Test
    public void testPriceSearchStrategy() throws Exception {
        // given
        BigDecimal price = BigDecimal.valueOf(21.37);
        PriceSearchStrategy searchStrategy = new PriceSearchStrategy(price);
        Product prod1 = mock(Product.class);
        given(prod1.getPriceWithoutDiscount()).willReturn(price);
        Product prod2 = mock(Product.class);
        given(prod2.getPriceWithoutDiscount()).willReturn(price.multiply(BigDecimal.valueOf(2)));
        Order order1 = new Order(Collections.singletonList(prod1), BigDecimal.valueOf(1));
        Order order2 = new Order(Collections.singletonList(prod2), BigDecimal.valueOf(1));

        // when then
        assertTrue(searchStrategy.filter(order1));
        assertFalse(searchStrategy.filter(order2));
    }

    @Test
    public void testProductNameSearchStrategy() throws Exception {
        // given
        String productName = "Kremówka";
        ProductNameSearchStrategy searchStrategy = new ProductNameSearchStrategy(productName);
        Product prod1 = mock(Product.class);
        given(prod1.getName()).willReturn(productName);
        Product prod2 = mock(Product.class);
        given(prod2.getName()).willReturn("Sernik z rodzynkami");
        Order order1 = new Order(Collections.singletonList(prod1), BigDecimal.valueOf(1));
        Order order2 = new Order(Collections.singletonList(prod2), BigDecimal.valueOf(1));

        // when then
        assertTrue(searchStrategy.filter(order1));
        assertFalse(searchStrategy.filter(order2));
    }

    @Test
    public void testClientNameSearchStrategy() throws Exception {
        // given
        String clientName = "Jan";
        ClientNameSearchStrategy searchStrategy = new ClientNameSearchStrategy(clientName);
        Address address1 = mock(Address.class);
        given(address1.getName()).willReturn(clientName);
        Shipment shipment1 = mock(Shipment.class);
        given(shipment1.getRecipientAddress()).willReturn(address1);
        Order order1 = mock(Order.class);
        given(order1.getShipment()).willReturn(shipment1);
        Address address2= mock(Address.class);
        given(address2.getName()).willReturn("Stefan");
        Shipment shipment2 = mock(Shipment.class);
        given(shipment2.getRecipientAddress()).willReturn(address2);
        Order order2 = mock(Order.class);
        given(order2.getShipment()).willReturn(shipment2);

        // when then
        assertTrue(searchStrategy.filter(order1));
        assertFalse(searchStrategy.filter(order2));
    }

    @Test
    public void testCompositeSearchStrategy() {
        // given
        String productName = "Rurka z bitą śmietaną";
        BigDecimal productPrice = BigDecimal.valueOf(21.37);
        BigDecimal discount = BigDecimal.ONE;

        CompositeSearchStrategy compositeSearchStrategy = new CompositeSearchStrategy();
        PriceSearchStrategy priceSearchStrategy = new PriceSearchStrategy(productPrice);
        ProductNameSearchStrategy nameSearchStrategy = new ProductNameSearchStrategy(productName);

        Product prod1 = mock(Product.class);
        given(prod1.getName()).willReturn(productName);
        given(prod1.getPriceWithoutDiscount()).willReturn(productPrice);
        Order order1 = new Order(Collections.singletonList(prod1), discount);

        Product prod2 = mock(Product.class);
        given(prod2.getName()).willReturn("Muffinka");
        given(prod2.getPriceWithoutDiscount()).willReturn(productPrice);
        Order order2 = new Order(Collections.singletonList(prod2), discount);

        Product prod3 = mock(Product.class);
        given(prod3.getName()).willReturn(productName);
        given(prod3.getPriceWithoutDiscount()).willReturn(BigDecimal.valueOf(420));
        Order order3 = new Order(Collections.singletonList(prod3), discount);

        // when
        compositeSearchStrategy.addStrategy(nameSearchStrategy);
        compositeSearchStrategy.addStrategy(priceSearchStrategy);

        // then
        assertTrue(compositeSearchStrategy.filter(order1));
        assertFalse(compositeSearchStrategy.filter(order2));
        assertFalse(compositeSearchStrategy.filter(order3));
    }
}

