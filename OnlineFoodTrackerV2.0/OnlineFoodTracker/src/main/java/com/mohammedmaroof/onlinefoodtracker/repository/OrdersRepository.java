package com.mohammedmaroof.onlinefoodtracker.repository;

import com.mohammedmaroof.onlinefoodtracker.entity.OrderEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrdersRepository extends MongoRepository<OrderEntry, ObjectId> {
    List<OrderEntry> findByCustomerName(String customerName);
}
