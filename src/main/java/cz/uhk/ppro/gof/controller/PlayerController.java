package cz.uhk.ppro.gof.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cz.uhk.ppro.gof.model.Player;
import cz.uhk.ppro.gof.service.PlayerService;
import cz.uhk.ppro.gof.service.RoleService;
import cz.uhk.ppro.gof.service.FractionService;

@Controller
public class PlayerController {
	
	@Autowired
	private PlayerService playerService;
	
	@Autowired
	private FractionService fractionService;
	

	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value = "/players", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getPlayers(Model model) {

		model.addAttribute("player", new Player());
		List<Player> listOfPlayers = playerService.getAllPlayers();

		model.addAttribute("fractionsList", fractionService.getAllFractions());

        model.addAttribute("rolesList", roleService.getAllRoles());
		model.addAttribute("listOfPlayers", listOfPlayers);
		return "players";
	}

	@RequestMapping(value = "/admin/addPlayer", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addPlayerPost(@ModelAttribute("player") Player player) {	
		if(player.getId()==0)
		{
			playerService.addPlayer(player);
		}
		else
		{	
			playerService.updatePlayer(player);
		}
		
		return "redirect:/players";
	}
	
	@RequestMapping(value = "/admin/addPlayer", method = RequestMethod.GET, headers = "Accept=application/json")
	public String addPlayerGet() {	
		
		return "redirect:/players";
	}

	@RequestMapping(value = "/admin/updatePlayer/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updatePlayer(@PathVariable("id") int id,Model model) {
		 model.addAttribute("player", playerService.getPlayer(id));
	        model.addAttribute("listOfPlayers", playerService.getAllPlayers());
			model.addAttribute("fractionsList", fractionService.getAllFractions());
	        model.addAttribute("rolesList", roleService.getAllRoles());
	        return "players";
	}

	@RequestMapping(value = "/admin/deletePlayer/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deletePlayer(@PathVariable("id") int id) {
		playerService.deletePlayer(id);
		 return "redirect:/players";

	}	
}
