package com.mohammedmaroof.onlinefoodtracker.Controllers;

import com.mohammedmaroof.onlinefoodtracker.entity.Order;
import com.mohammedmaroof.onlinefoodtracker.entity.User;
import com.mohammedmaroof.onlinefoodtracker.services.OrderServices;
import com.mohammedmaroof.onlinefoodtracker.services.UserServices;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrderServices orderServices;

    @Autowired
    private UserServices userServices;

    //view all the order list
    @GetMapping("{userName}")
    public ResponseEntity<List<Order>> getOrders(@PathVariable String userName){
        User user = userServices.findByUserName(userName);
        List<Order> allOrders = user.getOrderEntries();
        if (allOrders != null && !allOrders.isEmpty()) {
            return new ResponseEntity<>(allOrders, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //place order
    @PostMapping("{userName}")
    public ResponseEntity<Order> placeOrder(@PathVariable String userName, @RequestBody Order myOrder){
        try {
            orderServices.saveOrder(myOrder, userName);
            return new ResponseEntity<>(myOrder, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //get specific order by ID
    @GetMapping("/search/id/{orderId}")
    public ResponseEntity<Order> getOrder(@PathVariable ObjectId orderId){
        Optional<Order> orderEntry = orderServices.findById(orderId);
        if (orderEntry.isPresent()){
            return new ResponseEntity<>(orderEntry.get(), HttpStatus.OK);
        }
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //update order
    @PutMapping("/update/{userName}/{orderId}")
    public ResponseEntity<?> updateOrder(
            @PathVariable String userName,
            @PathVariable ObjectId orderId,
            @RequestBody Order newOrder)
    {
        Optional<Order> optionalOrderEntry = orderServices.findById(orderId);
        if(!optionalOrderEntry.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Order oldOrder = optionalOrderEntry.get();
            oldOrder.setCustomerName(newOrder.getCustomerName() != null && newOrder.getCustomerName().isEmpty() ?
                    newOrder.getCustomerName() : oldOrder.getCustomerName());
            oldOrder.setStatus(newOrder.getStatus() != null && !newOrder.getStatus().equals("") ?
                    newOrder.getStatus(): oldOrder.getStatus());
            oldOrder.setItems(newOrder.getItems() != null && !newOrder.getItems().equals("") ?
                    newOrder.getItems(): oldOrder.getItems());
        orderServices.saveOrder(oldOrder);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    //cancel an order
    @DeleteMapping("/cancel/{userName}/{orderId}")
    public ResponseEntity<Order> deleteOrder(@PathVariable ObjectId orderId, @PathVariable String userName){
        Optional<Order> orderEntry = orderServices.findById(orderId);
        if(orderEntry.isPresent()){
            orderServices.deleteById(orderId, userName);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}


