package com.sensedia.interview.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;

import com.sensedia.interview.domain.Order;
import com.sensedia.interview.domain.enumeration.Side;
import com.sensedia.interview.services.OrderBookService;
import com.sensedia.interview.services.impl.OrderBookServiceImpl;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderBookServiceImplTests {

	public static final String GOOG_NS = "GOOG.NS";
	public static final String APPL_NS = "APPL.NS";
	public static final String GS_NS = "GS.NS";

	private OrderBookService orderBookService;

	private List<Order> orderBook;

	@BeforeEach
	public void init() {
		this.orderBookService = spy(new OrderBookServiceImpl());

		Order buyGoogle = Order.builder().symbol(GOOG_NS).quantity(300).price(900.30).side(Side.BUY).build();
		Order sellGoogle = Order.builder().symbol(GOOG_NS).quantity(600).price(890.30).side(Side.SELL).build();
		Order buyApple = Order.builder().symbol(APPL_NS).quantity(400).price(552).side(Side.BUY).build();
		Order sellApple = Order.builder().symbol(APPL_NS).quantity(200).price(550).side(Side.SELL).build();
 		Order buyGS = Order.builder().symbol(GS_NS).quantity(300).price(130).side(Side.BUY).build();

		orderBook = List.of(buyGoogle, sellGoogle, buyApple, sellApple, buyGS);
	}

	@DisplayName("Should the number of buy orders equals to 3")
	@Test
	void shouldNumberOfBuyOrdersEquals() {
		long totalBuyOrder = orderBookService.calculateTotalBuyOrders(orderBook);
		assertEquals(3, totalBuyOrder);
	}

	@DisplayName("Should the number of sell orders equals to 2")
	@Test
	void shouldNumberOfSellOrdersEquals() {
		long totalBuyOrder = orderBookService.calculateTotalSellOrders(orderBook);
		assertEquals(2, totalBuyOrder);
	}

	@DisplayName("Should the total value of orders equals to 3022.6")
	@Test
	void shouldTotalValueOrdersEquals() {
		double totalBuyOrder = orderBookService.calculateTotalValueOrders(orderBook);
		assertEquals(3022.6, totalBuyOrder);
	}

	@DisplayName("should the total amount of orders be equal to 1800")
	@Test
	void shouldTotalQuantityOrdersEquals() {
		long totalBuyOrder = orderBookService.calculateTotalQuantityOrders(orderBook);
		assertEquals(1800, totalBuyOrder);
	}

}
