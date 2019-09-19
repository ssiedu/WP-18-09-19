package com.ssi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssi.models.InterestModel;
import com.ssi.services.BankingService;
import com.ssi.utilities.DateUtility;

@Controller
public class BankingController {

	@Autowired
	private BankingService service;
	
	@Autowired
	private DateUtility dateUtility;
	
	@RequestMapping("Calculate")
	public ModelAndView calculateInterest(@ModelAttribute("info") InterestModel model){
		System.out.println(dateUtility.getDate());
		service.calculateInterest(model);
		ModelAndView mv=null;
		if(model.getAmount()<50000){
			mv=new ModelAndView("result");
		}else{
			mv=new ModelAndView("resultgold");
		}
		return mv;
			
	}
	
	
	@RequestMapping("inputpage")
	public String showInputForm(){
		return "details";
	}
	
	
	
}
