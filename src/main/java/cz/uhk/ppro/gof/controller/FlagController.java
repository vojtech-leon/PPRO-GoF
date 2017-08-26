package cz.uhk.ppro.gof.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cz.uhk.ppro.gof.model.Flag;
import cz.uhk.ppro.gof.service.FlagService;
import cz.uhk.ppro.gof.service.FractionService;
import cz.uhk.ppro.gof.service.PlayerService;

@Controller
public class FlagController {
	
	@Autowired
	FlagService flagService;

	@Autowired
	private FractionService fractionService;
	
	@Autowired
	private PlayerService playerService;
	
	@RequestMapping(value = "/flags", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getFlags(Model model) {
		
		List<Flag> listOfFlags = flagService.getAllFlags();
		model.addAttribute("listOfFlags", listOfFlags);
		return "flags";
	}

	@RequestMapping(value = "/flags/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getFlagById(@PathVariable int id, Model model) {
		model.addAttribute("flagDetails", flagService.getFlag(id));
		return "flagDetails";
	}
	
	@RequestMapping(value = "/admin/flags", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getFlagsAdmin(Model model) {

		model.addAttribute("flag", new Flag());
		List<Flag> listOfFlags = flagService.getAllFlags();
		model.addAttribute("listOfFlags", listOfFlags);
		model.addAttribute("fractionsList", fractionService.getAllFractions());
		model.addAttribute("playersList", playerService.getAllPlayers());
		return "adminFlags";
	}

	@RequestMapping(value = "/admin/addFlag", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addFlagPost(@ModelAttribute("flag") Flag flag) {	
		if(flag.getId()==0)
		{
			flagService.addFlag(flag);
		}
		else
		{	
			flagService.updateFlag(flag);
		}
		
		return "redirect:/admin/flags";
	}
	
	@RequestMapping(value = "/admin/addFlag", method = RequestMethod.GET, headers = "Accept=application/json")
	public String addFlagGet() {	
		
		return "redirect:/admin/flags";
	}

	@RequestMapping(value = "/admin/updateFlag/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updateFlag(@PathVariable("id") int id,Model model) {
		 model.addAttribute("flag", flagService.getFlag(id));
	        model.addAttribute("listOfFlags", flagService.getAllFlags());
			model.addAttribute("fractionsList", fractionService.getAllFractions());
			model.addAttribute("playersList", playerService.getAllPlayers());
	        return "adminFlags";
	}

	@RequestMapping(value = "/admin/deleteFlag/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteFlag(@PathVariable("id") int id) {
		flagService.deleteFlag(id);
		 return "redirect:/admin/flags";

	}	
}
