package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Account;

@Controller
@RequestMapping(value = { "/login" })
public class LoginController {

	@GetMapping(value = { "" })
	public String loginPage(Model model) {
		Account accountDTO = new Account();
		accountDTO.setUsername("");
		accountDTO.setPassword("");

		model.addAttribute("accountDTO", accountDTO);
		model.addAttribute("error", null);
		System.out.println("hello");
		return "login";
	}

}