package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Account;
import service.AccountService;

@Controller
@RequestMapping(value = "/profile")
public class ProfileCotroller {
	@Autowired
	private AccountService accountService;

	@GetMapping
	public String getProfilePage(Model model) {
		return "profile";
	}

	@PostMapping(value = "/changepassword")
	public String changPassword(Model model, @RequestParam("accountName") String username,
			@RequestParam("currentPassword") String currentPassword, @RequestParam("newPassword") String newPassword,
			@RequestParam("againPassword") String againPassword) {
		Account acc = accountService.getAcc(username);
		
		boolean status = false;
		String mess = "";
		if (currentPassword.equals(acc.getPassword())) {
			if (newPassword.equals(againPassword)) {
				acc.setPassword(newPassword);
				accountService.updateAccount(username, newPassword);
				status = true;
				mess = "thanh cong";
			} else {
				mess = "nhap lai mat khau khong dung";
			}
		} else {
			mess = "mat khau hien tai khong dung";
		}
		model.addAttribute("status", status);
		model.addAttribute("mess", mess);
		return "redirect:/profile";
	}
}