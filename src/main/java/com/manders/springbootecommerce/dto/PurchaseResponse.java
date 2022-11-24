package com.manders.springbootecommerce.dto;

import lombok.Data;


@Data
public class PurchaseResponse {
  
  public PurchaseResponse(String orderTrackingNumber) {
    this.orderTrackingNumber = orderTrackingNumber;
  }

  private String orderTrackingNumber;
}
