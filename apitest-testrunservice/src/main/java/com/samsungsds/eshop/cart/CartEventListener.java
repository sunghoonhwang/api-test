package com.samsungsds.eshop.cart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import java.io.IOException;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;

@Service
public class CartEventListener {
  private final Logger logger = LoggerFactory.getLogger(CartEventListener.class);
  private final CartService cartService;

  public CartEventListener(CartService cartService) {
    this.cartService = cartService;
  }

  @RabbitListener(queues = "ApiTestResult")
  public void receiveMessage() throws IOException {
    
    logger.info("rabbit message received");
    // empty cart
    //logger.info("empty Cart : {}", orderPlaced.getOrderId());
    //cartService.emptyCart();
    //if(true){
    //       throw new AmqpRejectAndDontRequeueException("RabbitMQ message exception occured ");
    //}
  }
}

