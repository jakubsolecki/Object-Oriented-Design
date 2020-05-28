package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pl.edu.agh.internetshop.util.CustomAssertions.assertBigDecimalCompareValue;

import java.math.BigDecimal;


public class ProductTest {

	
    private static final String NAME = "Mr. Sparkle";
    private static final BigDecimal PRICE = BigDecimal.valueOf(1);
    private static final BigDecimal DISCOUNT = BigDecimal.valueOf(0.5);

	@Test
    public void testProductName() throws Exception {
        //given
    	
        // when
        Product product = new Product(NAME, PRICE, DISCOUNT);
        
        // then
        assertEquals(NAME, product.getName());
    }
    
    @Test
    public void testProductPrice() throws Exception {
        //given
    	
        // when
        Product product = new Product(NAME, PRICE, DISCOUNT);
        
        // then
        assertBigDecimalCompareValue(product.getPriceWithoutDiscount(), PRICE);
    }

    @Test
    public void testProductNullDiscount() throws Exception {
	    // when then
        Assertions.assertThrows(NullPointerException.class, ()->{
            Product product = new Product(NAME, PRICE, null);
        });
    }

    @Test
    public void testProductBadDiscount() throws Exception {
        // when then
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            Product product = new Product(NAME, PRICE, BigDecimal.valueOf(0));
        });
    }

    @Test
    public void testProductPriceWithDiscount() {
	    // given

        // when
	    Product product = new Product(NAME, PRICE, DISCOUNT);

	    // then
        assertEquals(product.getPriceWithDiscount(), DISCOUNT.multiply(PRICE));
    }

    @Test
    public void testProductDiscount() {
	    // given

        // when
        Product product = new Product(NAME, PRICE, DISCOUNT);

        // then
        assertEquals(product.getDiscount(), DISCOUNT);
    }
}