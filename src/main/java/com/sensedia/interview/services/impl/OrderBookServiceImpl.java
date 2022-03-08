package com.sensedia.interview.services.impl;

import com.sensedia.interview.domain.Order;
import com.sensedia.interview.domain.enumeration.Side;
import com.sensedia.interview.services.OrderBookService;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

@Service
public class OrderBookServiceImpl implements OrderBookService {

  @Override
  public long calculateTotalBuyOrders(List<Order> orderBook) {
	long buyOrder = orderBook.stream().filter(o -> o.getSide()== Side.BUY).count();
    return buyOrder;
  }

  @Override
  public long calculateTotalSellOrders(List<Order> orderBook) {
	  long sellOrder = orderBook.stream().filter(o -> o.getSide()== Side.SELL).count();
	  return sellOrder;
  }

  @Override
  public double calculateTotalValueOrders(List<Order> orderBook) {
	  double totalValue = orderBook.stream().mapToDouble(o-> o.getPrice()).sum();
	  return totalValue;
  }

  @Override
  public long calculateTotalQuantityOrders(List<Order> orderBook) {
	  long totalQuantity = orderBook.stream().mapToLong(o-> o.getQuantity()).sum();
	  return totalQuantity;
  }
}
