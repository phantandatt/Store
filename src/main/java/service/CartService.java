package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import model.Cart;
import respository.CartRespository;

@Service

public class CartService {

	
	@Autowired
	CartRespository cartRespository;
	

	public List<Cart> getCartByUsername(String username){
	
		return cartRespository.findByUsername(username);
	}


	public void save(Cart newCart) {
		// TODO Auto-generated method stub
		cartRespository.save(newCart);
	}
}
