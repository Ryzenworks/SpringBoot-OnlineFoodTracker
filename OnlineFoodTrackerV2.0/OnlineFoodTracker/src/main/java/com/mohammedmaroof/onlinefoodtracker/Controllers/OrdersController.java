package com.mohammedmaroof.onlinefoodtracker.Controllers;

import com.mohammedmaroof.onlinefoodtracker.entity.OrderStatus;
import com.mohammedmaroof.onlinefoodtracker.entity.OrderEntry;
import com.mohammedmaroof.onlinefoodtracker.services.OrderServices;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrderServices orderServices;


    //view all the order list
    @GetMapping
    public List<OrderEntry> getOrders(){
        return orderServices.getAllOrders();
    }

    //place order
    @PostMapping()
    public String placeOrder(@RequestBody OrderEntry myOrder){
        myOrder.setDate(LocalDateTime.now());
        orderServices.saveOrder(myOrder);
        return "Order placed successfully";
    }

    //get specific order by ID
    @GetMapping("/search/id/{orderId}")
    public OrderEntry getOrder(@PathVariable ObjectId orderId){
        return orderServices.findById(orderId).orElse(null);
    }

    //update order
    @PutMapping("/update/{orderId}")
    public OrderEntry updateOrder(@PathVariable ObjectId orderId, @RequestBody OrderEntry newOrderEntry) {
        OrderEntry oldOrderEntry = orderServices.findById(orderId).orElse(null);

        if(oldOrderEntry != null){
            oldOrderEntry.setCustomerName(newOrderEntry.getCustomerName() != null && newOrderEntry.getCustomerName().equals("") ? newOrderEntry.getCustomerName() : oldOrderEntry.getCustomerName());
            oldOrderEntry.setStatus(newOrderEntry.getStatus() != null && !newOrderEntry.getStatus().equals("") ? newOrderEntry.getStatus(): oldOrderEntry.getStatus());
            oldOrderEntry.setItems(newOrderEntry.getItems() != null && !newOrderEntry.getItems().equals("") ? newOrderEntry.getItems(): oldOrderEntry.getItems());
        }
        orderServices.saveOrder(oldOrderEntry);
        return oldOrderEntry;
    }

    //cancel an order
    @DeleteMapping("/cancel/{orderId}")
    public String deleteOrder(@PathVariable ObjectId orderId){
        orderServices.deleteById(orderId);
        return "Order:" + orderId + ", Successfully deleted";
    }

    //search an order by name
    @GetMapping("/search/name/{customerName}")
    public List<OrderEntry> searchOrder(@PathVariable String customerName){
        return orderServices.findByName(customerName);
    }
}


