package com.mohammedmaroof.onlinefoodtracker.services;

import com.mohammedmaroof.onlinefoodtracker.entity.OrderEntry;
import com.mohammedmaroof.onlinefoodtracker.repository.OrdersRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

//controllers -> service -> repository
@Component
public class OrderServices {


    @Autowired
    private OrdersRepository ordersRepository;


    public void saveOrder(OrderEntry orderEntry){
        ordersRepository.save(orderEntry);
    }

    public List<OrderEntry> getAllOrders(){
        return ordersRepository.findAll();
    }

    public Optional<OrderEntry> findById(ObjectId myId){
        return ordersRepository.findById(myId);
    }

    public void deleteById(ObjectId myId){
        ordersRepository.deleteById(myId);
    }

    public List<OrderEntry> findByName(String customerName){
        return ordersRepository.findByCustomerName(customerName);
    }


}
