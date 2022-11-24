package com.manders.springbootecommerce.service;

import com.manders.springbootecommerce.dto.Purchase;
import com.manders.springbootecommerce.dto.PurchaseResponse;

public interface CheckoutService {
  
  PurchaseResponse placeOrder(Purchase purchase);
}
