package com.mohammedmaroof.onlinefoodtracker.Controllers;

import com.mohammedmaroof.onlinefoodtracker.entity.OrderStatus;
import com.mohammedmaroof.onlinefoodtracker.entity.Orders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    private Map<Long, Orders> ordersMap = new HashMap<>();

    //view all the order list
    @GetMapping
    public List<Orders> getOrders(){
        return new ArrayList<>(ordersMap.values());
    }

    //place order
    @PostMapping("/place-order")
    public String placeOrder(@RequestBody Orders myOrder){
        ordersMap.put(myOrder.getOrderId(), myOrder);
        return "Order Placed Successfully";
    }

    //get specific order
    @GetMapping("/search/id/{orderId}")
    public Orders getOrder(@PathVariable long orderId){
        return ordersMap.get(orderId);
    }

    //update order status
    @PutMapping("/update-status/{orderId}"
    )
    public String updateOrderStatus(@PathVariable long orderId, @RequestBody OrderStatus orderStatus) {
        Orders order = ordersMap.get(orderId);
        if(order != null){
            order.setStatus(orderStatus);
        }
        return "Status Updated Successfully";
    }

    //cancel an order
    @DeleteMapping("/cancel/{orderId}")
    public String deleteOrder(@PathVariable long orderId){
        Orders order = ordersMap.get(orderId);
        if(order != null){
            ordersMap.remove(orderId);
        }
        return "Successfully Cancelled the order";
    }

    //search an order by name
    @GetMapping("/search/name/{customerName}")
    public Orders searchOrder(@PathVariable String customerName){
        return ordersMap.values().stream()
                .filter(order -> order.getCustomerName().equals(customerName))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found"));
    }
}


