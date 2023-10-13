package com.samsungsds.eshop.cart;

import java.util.List;
import java.util.Optional;

import com.google.common.collect.Lists;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    private final Logger logger = LoggerFactory.getLogger(CartService.class);
    private final CartItemRepository cartItemRepository;

    public CartService(final CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    public void emptyCart() {
        logger.info("emptyCart()");
        cartItemRepository.deleteAll();
    }

    public void addToCart(final CartItem cartItem) {
        logger.info("addToTestRunItems() : {}", cartItem);
        Optional<CartItem> alreadyExistCartItem = cartItemRepository.findById(cartItem.getId());
        if (alreadyExistCartItem.isPresent()) {
            //int newQuantity = alreadyExistCartItem.get().getQuantity() + cartItem.getQuantity();
            //cartItem.setQuantity(newQuantity);
        }
        cartItemRepository.save(cartItem);
    }

    //public List<CartItem> getCartItems() {
      //  logger.info("getTestRunItems()");
      //  return Lists.newArrayList(cartItemRepository.findAll());
    //}

    public List<CartItem> getCartItems() {
        logger.info("getTestRunItems()");

	try{
            Thread.sleep(300);
        }catch(InterruptedException e){
          e.printStackTrace();
        }

        Iterable<CartItem> items = cartItemRepository.findAll();
        for (CartItem cartItem : items) {
            logger.info(cartItem.toString());
        }

        return Lists.newArrayList(items);
    }

    public Long getCartItemsCount() {
        logger.info("getCartItemsCount()");
        return cartItemRepository.count();
    }
}
