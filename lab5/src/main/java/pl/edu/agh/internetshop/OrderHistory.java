package pl.edu.agh.internetshop;

import pl.edu.agh.internetshop.filters.SearchStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderHistory {
    private static OrderHistory instance = null;
    private final List<Order> orders;

    private OrderHistory(){
        this.orders = new ArrayList<>();
    }

    public static OrderHistory getInstance(){
        if(OrderHistory.instance == null){
            OrderHistory.instance = new OrderHistory();
        }
        return OrderHistory.instance;
    }

    public List<Order> searchOrderByStrategy(SearchStrategy strategy) {
        return this.orders.stream()
                .filter(strategy::filter)
                .collect(Collectors.toList());
    }

    public void addOrder(Order order) {
        orders.add(order);
    }


    public List<Order> getOrders() {
        return this.orders;
    }
}
