package cz.uhk.ppro.gof.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cz.uhk.ppro.gof.model.Scan;
import cz.uhk.ppro.gof.service.FlagService;
import cz.uhk.ppro.gof.service.FractionService;
import cz.uhk.ppro.gof.service.PlayerService;
import cz.uhk.ppro.gof.service.ScanService;

@Controller
public class ScanController {
	
	@Autowired
	ScanService scanService;
	
	@Autowired
	private FractionService fractionService;
	
	@Autowired
	private PlayerService playerService;
	
	@Autowired
	private FlagService flagService;
	
	@RequestMapping(value = "/admin/scans", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getScans(Model model) {
		
		List<Scan> listOfScans = scanService.getAllScans();
		model.addAttribute("scan", new Scan());
		model.addAttribute("listOfScans", listOfScans);
		model.addAttribute("fractionsList", fractionService.getAllFractions());
		model.addAttribute("playersList", playerService.getAllPlayers());
		model.addAttribute("flagsList", flagService.getAllFlags());
		return "scans";
	}
	@RequestMapping(value = "/admin/scan/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getFlagById(@PathVariable int id, Model model) {
		model.addAttribute("scanDetails", scanService.getScan(id));
		return "scanDetails";
	}

	@RequestMapping(value = "/admin/addScan", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addScanPost(@ModelAttribute("scan") Scan scan) {	
		if(scan.getId()==0)
		{
			scanService.addScan(scan);
		}
		else
		{	
			scanService.updateScan(scan);
		}
		
		return "redirect:/admin/scans";
	}
	@RequestMapping(value = "/admin/addScan", method = RequestMethod.GET, headers = "Accept=application/json")
	public String addScanGet() {	
				
		return "redirect:/admin/scans";
	}

	@RequestMapping(value = "/admin/updateScan/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updateScan(@PathVariable("id") int id,Model model) {
		 model.addAttribute("scan", scanService.getScan(id));
	        model.addAttribute("listOfScans", scanService.getAllScans());
			model.addAttribute("fractionsList", fractionService.getAllFractions());
			model.addAttribute("playersList", playerService.getAllPlayers());
			model.addAttribute("flagsList", flagService.getAllFlags());
	        return "scans";
	}
}
