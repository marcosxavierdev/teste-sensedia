package com.sensedia.interview.services;

import com.sensedia.interview.domain.Order;
import java.util.List;

public interface OrderBookService {

  long calculateTotalBuyOrders(List<Order> orderBook);
  long calculateTotalSellOrders(List<Order> orderBook);
  double calculateTotalValueOrders(List<Order> orderBook);
  long calculateTotalQuantityOrders(List<Order> orderBook);

}
