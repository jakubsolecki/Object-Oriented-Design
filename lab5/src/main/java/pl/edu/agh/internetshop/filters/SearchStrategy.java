package pl.edu.agh.internetshop.filters;

import pl.edu.agh.internetshop.Order;

public interface SearchStrategy {
    public boolean filter(Order order);
}
