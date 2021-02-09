package xyz.morlotti.virtualbookcase.userwebsite.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import xyz.morlotti.virtualbookcase.userwebsite.FeignProxy;

@Controller
public class BookController
{
	@Autowired
	FeignProxy feignProxy;

	@RequestMapping(value="/book", method = RequestMethod.GET)
	public String book(Model model)
	{
		model.addAttribute("genres", feignProxy.listGenres());

		return "book";
	}

	@RequestMapping(value="/search", method = RequestMethod.GET)
	public String search()
	{
		return "search";
	}
}