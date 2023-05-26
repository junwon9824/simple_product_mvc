package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.example.demo.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.BookMarkDto;
import com.example.demo.dto.TransferDto;
import com.example.demo.entity.BankAccount;
import com.example.demo.entity.BookMark;
import com.example.demo.entity.User;
import com.example.demo.service.BankAccountService;
import com.example.demo.service.BookMarkService;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/bookmarks")
public class BookMarkController {

	@Autowired
	private BookMarkService bookMarkService;

	@Autowired
	private UserService userService;
	@Autowired
	private BankAccountService bankaccountservice;
	@Autowired
	private BankAccountRepository bankAccountRepository;

	@GetMapping
	public String getUserBookMarks(Model model, HttpServletRequest request, HttpSession session) {
		System.out.println("here");
		session = request.getSession();
		User user = (User) session.getAttribute("user");
		String userid = user.getUserid();
		System.out.println("userid" + userid);

		List<BookMark> bookMarks = bookMarkService.getUserAllBookmarks(userid, user);

		model.addAttribute("bookMarks", bookMarks);
		model.addAttribute("userid", userid);

		System.out.println("here2");
		return "BookMark/bookMark";

	}

	@GetMapping("/create")
	public String createBookMarkForm(Model model, HttpSession session, HttpServletRequest request) {

		BookMarkDto bookMark = new BookMarkDto();
		session = request.getSession();
		System.out.println("create");
		User user = (User) session.getAttribute("user");
		String userid = user.getUserid();

		System.out.println("userid" + userid);
		User user1 = userService.getUserByUserId(userid);
		System.out.println("username" + user1.getUsername());

//		bookMark.setUser(user1);

		bookMark.setUser(user);
		model.addAttribute("bookMark", bookMark);

		return "BookMark/bookMarkForm";
	}

	@PostMapping("/create")
	public String createBookMark(@ModelAttribute("bookMark") BookMarkDto bookMark, HttpSession session,
			HttpServletRequest request) {

		session = request.getSession();
		User user = (User) session.getAttribute("user");

		System.out.println(user.toString());
		String userid = user.getUserid();

		System.out.println("userid_create" + userid);

		System.out.println("bookmark1 name" + bookMark.getBookMarkName());

		BookMark bookMark2 = bookMark.toEntity();// 폼에서 입력한 북마크 내용

		System.out.println("bookmark getname " + bookMark2.getBookMarkName());

		if (userService.getUserByUsername(bookMark2.getBookMarkName()) != null) { // db에 잇는 유저

			User targetUser = userService.getUserByUsername(bookMark2.getBookMarkName());
			System.out.println("targetuser" + targetUser.toString());

			List<BankAccount> bankAccounts = targetUser.getBankAccounts();

			System.out.println("bankaccounts" + bankAccounts.toString());
			System.out.println("bookMark2.getBookMarkAccountNumber " + bookMark2.getBookMarkAccountNumber());

			BankAccount targetBankAccount = bankAccountRepository
					.findByAccountNumber(bookMark2.getBookMarkAccountNumber());

			if (bankAccounts.indexOf(targetBankAccount) == -1) { // 계좌가 존재하지 않을 경우
				System.out.println("계좌를 똑바로 입력");
				return "redirect:create";
			} else { // 등록 성공
				bookMarkService.createBookMark(bookMark);
				return "redirect:/bookmarks";
			}
		}

		// 사용자가 없을 경우
		System.out.println("해당사용자 없음");
		return "redirect:create";
	}

	@GetMapping("/edit/{id}")
	public String editBookMark(@PathVariable("id") Long id, Model model) {
		BookMark bookMark = bookMarkService.getBookMarkById(id);

		if (bookMark != null) {
			model.addAttribute("bookMark", bookMark);
			return "BookMark/bookMarkFormEdit";
		} else {
			// Handle error when bookmark is not found
			return "redirect:/bookmarks";
		}
	}

	@PostMapping("/edit/{id}")
	public String updateBookMark(@PathVariable("id") Long id, @ModelAttribute("bookMark") BookMarkDto updatedBookMark) {
		BookMark bookMark = bookMarkService.updateBookMark(id, updatedBookMark);
		if (bookMark != null) {
			return "redirect:/bookmarks";
		}
		return "error";
	}

	@GetMapping("/delete/{id}")
	public String deleteBookMark(@PathVariable("id") Long id) {
		// Delete the bookmark from the database
		bookMarkService.deleteBookMark(id);

		return "redirect:/bookmarks";
	}
//
//	@GetMapping("/transferbookmark/{recepientAccountNumber}")
//	public String transferform(@PathVariable("recepientAccountNumber") String recepientAccountNumber, Model model,
//			HttpServletRequest request) {
//
//		System.out.println("transferbookmark");
//		HttpSession session = request.getSession();
//		User user = (User) session.getAttribute("user");
//		String userid = user.getUserid();
//		TransferDto transferDto = new TransferDto();
//		transferDto.setSender(user);
//		transferDto.setRecipient_banknumber(recepientAccountNumber);
//
//		BankAccount bankAccount = bankaccountservice.getBankAccountByAccountnumber(recepientAccountNumber);
//		String recipient_name = bankAccount.getUser().getUsername();
//		transferDto.setRecipient_name(recipient_name);
//
//		System.out.println("log users" + transferDto.getSender().getBankAccounts());
//
//		model.addAttribute("Log", transferDto);
//		return "BookMark/transfer";
//	}

	@GetMapping("/transferbookmark/{recepientAccountNumber}")
	public String transferform(@PathVariable("recepientAccountNumber") String recepientAccountNumber, Model model,
			HttpServletRequest request) {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String userid = user.getUserid();
		TransferDto transferDto = new TransferDto();
		transferDto.setSender(user);
		transferDto.setRecipient_banknumber(recepientAccountNumber);

		BankAccount bankAccount = bankaccountservice.getBankAccountByAccountnumber(recepientAccountNumber);
		String recipient_name = bankAccount.getUser().getUsername();
		transferDto.setRecipient_name(recipient_name);
		List<BankAccount> bankAccounts = bankAccountRepository.findAllByUserId(user.getId());

		model.addAttribute("Log", transferDto);
		model.addAttribute("bankAccounts", bankAccounts);
		return "BookMark/transfer";
	}

}
