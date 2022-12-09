package com.manders.springbootecommerce.service;

import java.util.Set;
import java.util.UUID;
import javax.transaction.Transactional;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.manders.springbootecommerce.dao.CustomerRepository;
import com.manders.springbootecommerce.dto.Purchase;
import com.manders.springbootecommerce.dto.PurchaseResponse;
import com.manders.springbootecommerce.entity.Address;
import com.manders.springbootecommerce.entity.Customer;
import com.manders.springbootecommerce.entity.Order;
import com.manders.springbootecommerce.entity.OrderItem;


@Service
public class CheckoutServiceImpl implements CheckoutService {
  
  @Autowired
  private CustomerRepository customerRepository;

  @Override
  @Transactional
  public PurchaseResponse placeOrder(Purchase purchase) {
    // retrieve the order info from dto
    Order order = purchase.getOrder();
    
    // generate tracking number
    String orderTrackingNumber = generatedOrderTrackingNumber();
    order.setOrderTrackingNumber(orderTrackingNumber);
    
    // populate order with orderItems
    Set<OrderItem> orderItems = purchase.getOrderItems();
    orderItems.forEach(item -> order.add(item));
    
    // populate order with shippingAddress
    Address shippingAddress = purchase.getShippingAddress();
    order.setShippingAddress(shippingAddress);
    
    // populate customer with order
    Customer customer = purchase.getCustomer();
    customer.add(order);
    
    // save to database
    customerRepository.save(customer);
    
    // return a response
    return new PurchaseResponse(orderTrackingNumber);
  }

  private String generatedOrderTrackingNumber() {
    // generate a random UUID number(UUID-version4)
    return UUID.randomUUID().toString();
  }

}
