package cz.uhk.ppro.gof.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cz.uhk.ppro.gof.model.Fraction;
import cz.uhk.ppro.gof.service.FractionService;
import cz.uhk.ppro.gof.service.ScanService;

@Controller
public class FractionController {
	
	@Autowired
	FractionService fractionService;
	
	@Autowired
	ScanService scanService;
	
	@RequestMapping(value = "/fractions", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getFractions(Model model) {
		
		List<Fraction> listOfFractions = fractionService.getAllFractions();
		model.addAttribute("fraction", new Fraction());
		model.addAttribute("listOfFractions", listOfFractions);
		model.addAttribute("listOfScans", scanService.getAllScans());
		return "fractions";
	}

	@RequestMapping(value = "/admin/updateFraction", method = RequestMethod.POST, headers = "Accept=application/json")
	public String updateFractionPost(@ModelAttribute("fraction") Fraction fraction) {	
			
		fractionService.updateFraction(fraction);
		
		return "redirect:/fractions";
	}
	
	@RequestMapping(value = "/admin/updateFraction", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updateFractionGet() {	
				
		return "redirect:/fractions";
	}

	@RequestMapping(value = "/admin/updateFraction/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updateFractionForm(@PathVariable("id") int id,Model model) {
		 	model.addAttribute("fraction", fractionService.getFraction(id));
	        model.addAttribute("listOfFractions", fractionService.getAllFractions());
	        return "fractions";
	}

}
