package cz.uhk.ppro.gof.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {



	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout, ModelMap model) {

	  if (error != null) {
		model.addAttribute("error", "Špatné jméno nebo heslo!");
	  }

	  if (logout != null) {
		model.addAttribute("msg", "Uživatel úspìšnì odhlášen.");
	  }

	  return "login";

	}

	//for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accesssDenied(ModelMap model, Principal user) {

		if (user != null) {
			model.addAttribute("user",user);
		}

	  return "403";

	}

	
}
