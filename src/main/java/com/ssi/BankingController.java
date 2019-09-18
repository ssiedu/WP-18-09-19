package com.ssi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BankingController {

	
	@RequestMapping("Calculate")
	public ModelAndView calculateInterest(@ModelAttribute("info") InterestModel model){
		
		int interest=(model.getAmount()*model.getTime()*5)/100;
		model.setInterest(interest);
		ModelAndView mv=null;
		if(model.getAmount()<50000){
			mv=new ModelAndView("result.jsp");
		}else{
			mv=new ModelAndView("resultgold.jsp");
		}
		return mv;
			
	}
	
	
	@RequestMapping("inputpage")
	public String showInputForm(){
		return "details.jsp";
	}
	
	
	
}
