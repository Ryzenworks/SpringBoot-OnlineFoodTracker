package com.mohammedmaroof.onlinefoodtracker.services;

import com.mohammedmaroof.onlinefoodtracker.entity.Order;
import com.mohammedmaroof.onlinefoodtracker.entity.User;
import com.mohammedmaroof.onlinefoodtracker.repository.OrdersRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

//controllers -> service -> repository
@Component
public class OrderServices {


    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private UserServices userServices;

    @Transactional
    public void saveOrder(Order order, String userName){
        try {
            User user = userServices.findByUserName(userName);
            order.setDate(LocalDateTime.now());
            Order savedOrder = ordersRepository.save(order);
            user.getOrderEntries().add(savedOrder);
            userServices.saveEntry(user);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void saveOrder(Order order){
        try {
            order.setDate(LocalDateTime.now());
            ordersRepository.save(order);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public List<Order> getAllOrders(){
        return ordersRepository.findAll();
    }

    public Optional<Order> findById(ObjectId myId){
        return ordersRepository.findById(myId);
    }

    public void deleteById(ObjectId myId, String userName){
        User user = userServices.findByUserName(userName);
        //loops all over the orderEntries
        user.getOrderEntries().removeIf(orderEntry -> orderEntry.getOrderId().equals(myId));
        userServices.saveEntry(user);
        ordersRepository.deleteById(myId);
    }

    public List<Order> findByName(String customerName){
        return ordersRepository.findByCustomerName(customerName);
    }


}
