package com.orderapp.Online_Order_App.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.orderapp.Online_Order_App.dto.BillResponse;
import com.orderapp.Online_Order_App.dto.OrderItemRequest;
import com.orderapp.Online_Order_App.dto.OrderRequest;
import com.orderapp.Online_Order_App.dto.PaymentDto;
import com.orderapp.Online_Order_App.entity.Food;
import com.orderapp.Online_Order_App.entity.Order;
import com.orderapp.Online_Order_App.entity.OrderItems;
import com.orderapp.Online_Order_App.entity.OrderStatus;
import com.orderapp.Online_Order_App.entity.Restaurant;
import com.orderapp.Online_Order_App.entity.User;
import com.orderapp.Online_Order_App.exception.PaymentFailedExeption;
import com.orderapp.Online_Order_App.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImplementation implements OrderService {

    private final RestaurantService restaurantService;
    private final FoodService foodService;
    private final OrderRepository orderRepository;
    private final UserService userService;

    @Override
    public BillResponse generatedBill(OrderRequest orderRequest) {

        Restaurant restaurant = restaurantService.getById(orderRequest.getRestaurantId());
        StringBuilder summary = new StringBuilder();

        float totalPrice = 0;

        for (OrderItemRequest orderItem : orderRequest.getOrderItem()) {
            Food food = foodService.getFoodById(orderItem.getFoodId());
            float price = food.getPrice() * orderItem.getQuantity();
            totalPrice += price;
            summary.append(food.getName())
                   .append(" x ")
                   .append(orderItem.getQuantity())
                   .append(" = ₹")
                   .append(price)
                   .append("\n");
        }

        return new BillResponse(restaurant.getName(), summary.toString(), totalPrice);
    }

    @Override
    public String payAndPlaceOrder(PaymentDto payment) {
    	//simulated payment
        if (payment.isPaymentSuccesful()) {
            Order order = new Order();
            order.setStatus(OrderStatus.PLACED);

            Restaurant restaurant = restaurantService.getById(payment.getRestaurantId());
            //set restaurant to order
            order.setRestaurant(restaurant);
            
            //set user to order
            User user = userService.getUser(payment.getUserId());
            order.setUser(user);

            List<OrderItems> items = new ArrayList<>();
            double totalPrice = 0;

            for (OrderItemRequest request : payment.getOrderItems()) {
                Food food = foodService.getFoodById(request.getFoodId());

                OrderItems orderItem = new OrderItems();
                orderItem.setFood(food);
                orderItem.setQuantity(request.getQuantity());
                orderItem.setOrder(order);

                items.add(orderItem);

                double price = food.getPrice() * request.getQuantity();
                totalPrice = totalPrice + price;
            }

            // 🔥 Set items and total to the order
            order.setOrderItems(items);
            order.setTotalPrice(totalPrice);

            // 🔥 Save the order (cascades to items because of CascadeType.ALL)
            orderRepository.save(order);

            return "Order has been placed successfully!";
        } else {
            throw new PaymentFailedExeption("Payment was not successful, hence order cannot be placed.");
        }
    }

	@Override
	public void deleteOrder(Integer id) {
		Order order = getOrder(id);
		orderRepository.delete(order);
		
	}

	@Override
	public Order getOrder(Integer id) {
		Optional<Order> order = orderRepository.findById(id);
		if(order.isPresent()) {
			return order.get();
		}
		throw new NoSuchElementException("Order with ID:"+id+" does not exist");
		
	}

	@Override
	public Order updateStatusByAdmin(OrderStatus status, Integer id) {
		Order order = getOrder(id);
		order.setStatus(status);
		return orderRepository.save(order);
	}

	@Override
	public String cancelOrder(Integer id) {
		Order order = getOrder(id);
		order.setStatus(OrderStatus.CANCELLED);
		return "Order cancelled,your money will be refunded in 12 buisness hours";
	}

}
