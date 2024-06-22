package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;
import model.Account;
import model.Cart;
import service.CartService;

@Controller
public class PayController {

	@Autowired
	CartService cartService;
	@GetMapping("/checkout")
	public String checkoutpage(HttpSession session, Model model) {
		Account account = (Account) session.getAttribute("acc");
		
		String username = account.getUsername();
		List<Cart> carts = cartService.getCartByUsername(username);
		double TotalPrice = 0;
		for (Cart cart : carts) {
			TotalPrice += cart.getPrice();
		}
		model.addAttribute("ListCart", carts);
		model.addAttribute("TotalPrice", TotalPrice);
		
		return "checkout";
	}
}
