package cz.uhk.ppro.gof.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import cz.uhk.ppro.gof.model.Flag;
import cz.uhk.ppro.gof.model.Player;
import cz.uhk.ppro.gof.service.FlagService;
import cz.uhk.ppro.gof.service.PlayerService;


@Controller
public class HomeController {

	@Autowired
	private PlayerService playerService;
	
	@Autowired
	private FlagService flagService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getHome(ModelMap model) {
		List<Flag> listOfFlags = flagService.getAllFlags();
		model.addAttribute("listOfFlags", listOfFlags);
		List<Player> listOfPlayers = playerService.getAllPlayers();
		model.addAttribute("listOfPlayers", listOfPlayers);
		
		return "home";
	}
}
