package com.sensedia.interview.domain;

import com.sensedia.interview.domain.enumeration.Side;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Order {

  private String symbol;

  private int quantity;
  private double price;

  private Side side;

}
