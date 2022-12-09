package com.manders.springbootecommerce.dto;

import java.util.Set;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.manders.springbootecommerce.entity.Address;
import com.manders.springbootecommerce.entity.Customer;
import com.manders.springbootecommerce.entity.Order;
import com.manders.springbootecommerce.entity.OrderItem;
import lombok.Data;

@Data
public class Purchase {
  private Customer customer;
  
  @JsonProperty("shippingAddressTest")
  private Address shippingAddress;
  
  private Order order;
  
  private Set<OrderItem> orderItems;
}
